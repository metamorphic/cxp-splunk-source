package cxp.ingest;

import com.fasterxml.jackson.databind.ObjectMapper;
import cxp.ingest.model.*;
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
     * @param event SplunkEvent
     * @return InternetGatewayDevice
     */
    public InternetGatewayDevice transform(SplunkEvent event) {
        try {
            SplunkSearchResult result = mapper.readValue(event.toString(), SplunkSearchResult.class);
            TR69Response response = mapper.readValue(result.getRaw(), TR69Response.class);
            CWMPInform message = soapParser.getResult(response.getSrcSoapXml(), CWMPInform.class);
            DeviceSummaries summaries = summaryParser.parse(message.getParameterValue("InternetGatewayDevice.DeviceSummary"));

            InternetGatewayDevice out = new InternetGatewayDevice();
            out.setEventTime(message.getCurrentTime()); // or response.endTime or response.timestamp ?
            out.setManufacturer(message.getDeviceId().getManufacturer());
            out.setManufacturerOUI(message.getDeviceId().getOui());
            out.setProductClass(message.getDeviceId().getProductClass());
            out.setSerialNumber(message.getDeviceId().getSerialNumber());
            out.setHardwareVersion(message.getParameterValue("InternetGatewayDevice.DeviceInfo.HardwareVersion"));
            out.setSoftwareVersion(message.getParameterValue("InternetGatewayDevice.DeviceInfo.SoftwareVersion"));
            out.setManagementServerURL(message.getParameterValue("InternetGatewayDevice.ManagementServer.ConnectionRequestURL"));
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

        } catch (IOException e) {
            e.printStackTrace();
            throw new MessageTransformationException("Unable to transform splunk event: " + e.getMessage(), e);
        }
    }
}
