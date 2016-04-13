package cxp.ingest;

import com.fasterxml.jackson.databind.ObjectMapper;
import cxp.ingest.model.*;
import cxp.ingest.util.ChunkedDataParser;
import cxp.ingest.util.DeviceSummaryParser;
import cxp.ingest.util.SoapParser;
import org.springframework.integration.splunk.event.SplunkEvent;
import org.springframework.integration.transformer.MessageTransformationException;

import java.io.IOException;

/**
 * Created by markmo on 2/04/2016.
 */
public class TR69MessageTransformer implements MessageTransformer<InternetGatewayDevice> {

    private static ObjectMapper mapper;
    private static SoapParser soapParser;
    private static DeviceSummaryParser summaryParser;

    static {
        mapper = new ObjectMapper();
        soapParser = new SoapParser();
        summaryParser = new DeviceSummaryParser();
    }

    /**
     * Looks like some of the required information must be aggregated over multiple events,
     * e.g. upTime and lanDeviceErrorsReceived.
     * We could either maintain state in the streaming processor (Spring XD), or just write
     * events to HDFS and aggregate there using Spark.
     *
     * Requests (in one event) must be matched with responses (in another event) using
     * JSESSIONID. Rather than match in the stream, write as individual records to HDFS,
     * then use Spark to join.
     *
     * ? what to do about messages with no JSESSIONID?
     * If no JSESSIONID, then request and response appear together.
     *
     * @param event SplunkEvent
     * @return InternetGatewayDevice
     */
    public InternetGatewayDevice transform(SplunkEvent event) {
        try {
            SplunkSearchResult result = mapper.readValue(event.toString(), SplunkSearchResult.class);
            TR69Response response = mapper.readValue(result.getRaw(), TR69Response.class);

            InternetGatewayDevice out = extractFields(response);

            // TODO
            // how to return multiple record types?
            // * GetParameterValues (dest_content)
            // * Inform response (src_content)
            //
            // * getCircuitsforIpRequest (src_content)
            // * getCircuitsforIpResponse (dest_content)
            //
            // * error record ?

            // otherwise dest_content is HTML error page
            if (response.getStatus() != 200) {
                CWMPGetParameterValues requestMessage = soapParser.getResult(response.getDestContent(), CWMPGetParameterValues.class);
            } else {
                // write record of error to HDFS?
            }

            return out;

        } catch (IOException e) {
            e.printStackTrace();
            throw new MessageTransformationException("Unable to transform splunk event: " + e.getMessage(), e);
        }
    }

    private InternetGatewayDevice extractFields(TR69Response response) {
        InternetGatewayDevice out = new InternetGatewayDevice();

        String xml = ChunkedDataParser.read(response.getSrcContent());
        CWMPInform message = soapParser.getResult(xml, CWMPInform.class);
        DeviceSummaries summaries = summaryParser.parse(message.getParameterValue("InternetGatewayDevice.DeviceSummary"));

        out.setEventTime(message.getCurrentTime()); // or response.endTime or response.timestamp ?
        out.setManufacturer(message.getDeviceId().getManufacturer());
        out.setManufacturerOUI(message.getDeviceId().getOui());
        out.setProductClass(message.getDeviceId().getProductClass());
        out.setSerialNumber(message.getDeviceId().getSerialNumber());
        out.setHardwareVersion(message.getParameterValue("InternetGatewayDevice.DeviceInfo.HardwareVersion"));
        out.setSoftwareVersion(message.getParameterValue("InternetGatewayDevice.DeviceInfo.SoftwareVersion"));
        out.setManagementServerURL(message.getParameterValue("InternetGatewayDevice.ManagementServer.ConnectionRequestURL"));

        // include all parameter values
        out.setParameterValues(message.getParameterValues());

        // include all device summaries
        out.setDeviceSummaries(summaries.get());

        // meta fields
        out.setManagementServerUsername(response.getUser()); // ??
        out.setLanDeviceTotalBytesReceived(response.getBytesIn());
        out.setLanDeviceTotalBytesSent(response.getBytesOut());
        out.setLanDeviceTotalPacketsReceived(response.getAckPacketsIn());
        out.setLanDeviceTotalPacketsSent(response.getAckPacketsOut());
        out.setLanDeviceHostActive(response.getStatus() == 200);
        out.setLanDeviceAssociatedDeviceIpAddress(response.getSrcIp()); // appears the same as response.cip
        out.setLanDeviceAssociatedDeviceMacAddress(response.getSrcMac());
        out.setLanDeviceAssociatedDeviceType(response.getSite()); // ??
        out.setSessionId(response.getHeaderValue("JSESSIONID"));

        return out;
    }

}
