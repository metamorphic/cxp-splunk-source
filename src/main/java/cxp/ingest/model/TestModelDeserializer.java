package cxp.ingest.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by markmo on 2/04/2016.
 */
public class TestModelDeserializer extends JsonDeserializer<TestModel> {

    @Override
    public TestModel deserialize(JsonParser jp, DeserializationContext ctx)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String clientIp = node.get("clientip").asText();
        String uriPath = node.get("uri_path").asText();
        String sessionId = node.get("JSESSIONID").asText();
        String source = node.get("source").asText();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss");
        Date requestTime;
        try {
            requestTime = new Date(formatter.parse(node.get("req_time").asText()).getTime());
        } catch (ParseException e) {
            throw new IOException("Cannot parse req_time: " + e.getMessage(), e);
        }
        // Nested record currently not supported for field: requestTime of type: java.sql.Date
        String requestTimeStr = requestTime.toString();
        return new TestModel(clientIp, uriPath, sessionId, source, requestTimeStr);
    }
}
