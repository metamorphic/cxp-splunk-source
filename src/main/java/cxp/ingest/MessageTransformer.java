package cxp.ingest;

import org.springframework.integration.splunk.event.SplunkEvent;

/**
 * Created by markmo on 10/04/2016.
 */
public interface MessageTransformer<T> {

    T transform(SplunkEvent event);
}
