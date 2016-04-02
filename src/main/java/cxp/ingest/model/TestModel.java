package cxp.ingest.model;

import java.io.Serializable;

/**
 * Created by markmo on 2/04/2016.
 */
public class TestModel implements Serializable {

    private String clientIp;
    private String uriPath;
    private String sessionId;
    private String source;
    private String requestTime;

    public TestModel(String clientIp, String uriPath, String sessionId, String source, String requestTime) {
        this.clientIp = clientIp;
        this.uriPath = uriPath;
        this.sessionId = sessionId;
        this.source = source;
        this.requestTime = requestTime;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        boolean multiline = true;
        String indent = "";
        String delim = " ";
        String edgeDelim = "";
        if (multiline) {
            indent = "    ";
            delim = edgeDelim = "\n";
        }
        StringBuilder sb = new StringBuilder("{")
                .append(edgeDelim)
                .append(indent).append("\"clientIp\": \"").append(clientIp).append("\",").append(delim)
                .append(indent).append("\"uriPath\": \"").append(uriPath).append("\",").append(delim)
                .append(indent).append("\"sessionId\": \"").append(sessionId).append("\",").append(delim)
                .append(indent).append("\"source\": \"").append(source).append("\",").append(delim)
                .append(indent).append("\"requestTime\": \"").append(requestTime).append("\"").append(edgeDelim)
                .append("}");
        return sb.toString();
    }
}
