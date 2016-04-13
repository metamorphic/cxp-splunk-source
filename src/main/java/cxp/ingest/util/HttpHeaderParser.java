package cxp.ingest.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by markmo on 13/04/2016.
 */
public class HttpHeaderParser {

    public static Map<String, String> parseHTTPHeaders(InputStream inputStream)
            throws IOException {
        int charRead;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append((char) (charRead = inputStream.read()));
            if ((char) charRead == '\r') {
                sb.append((char) inputStream.read());
                charRead = inputStream.read();
                if (charRead == '\r') {
                    sb.append((char) inputStream.read());
                    break;
                } else {
                    sb.append((char) charRead);
                }
            }
        }

        String[] headersArray = sb.toString().split("\r\n");
        Map<String, String> headers = new HashMap<>();
        for (int i = 1; i < headersArray.length - 1; i++) {
            headers.put(headersArray[i].split(": ")[0],
                    headersArray[i].split(": ")[1]);
        }

        return headers;
    }
}
