package cxp.ingest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import cxp.ingest.model.TestModel;
import cxp.ingest.model.TestModelDeserializer;
import org.springframework.integration.splunk.event.SplunkEvent;
import org.springframework.integration.transformer.MessageTransformationException;

import java.io.IOException;

/**
 * Created by markmo on 2/04/2016.
 */
public class MessageTransformer {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(TestModel.class, new TestModelDeserializer());
        mapper.registerModule(module);
    }

    public TestModel transform(SplunkEvent event) {
        try {
            return mapper.readValue(event.toString(), TestModel.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MessageTransformationException("Unable to transform splunk event: " + e.getMessage(), e);
        }
    }
}
