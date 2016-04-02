import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.splunk.*;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by markmo on 1/04/2016.
 */
public class SplunkTest {

    @Test
    public void testConnection() throws Exception {
        ServiceArgs loginArgs = new ServiceArgs();
        loginArgs.setUsername("admin");
        loginArgs.setPassword("password");
        loginArgs.setHost("localhost");
        loginArgs.setPort(8089);

        HttpService.setSslSecurityProtocol(SSLSecurityProtocol.TLSv1_2);

        Service service = Service.connect(loginArgs);

        SavedSearch savedSearch = service.getSavedSearches().get("www1_access_20160331PM");

        Job jobSavedSearch;

        try {
            jobSavedSearch = savedSearch.dispatch();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw e;
        }

        while (!jobSavedSearch.isDone()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw e;
            }
        }

        // Specify CSV as the output mode for results
        JobResultsArgs resultsArgs = new JobResultsArgs();
        resultsArgs.setOutputMode(JobResultsArgs.OutputMode.CSV);

        // Display results
        InputStream results = jobSavedSearch.getResults(resultsArgs);
        ResultsReaderCsv resultsReader = new ResultsReaderCsv(results);
        HashMap<String, String> event;
        System.out.println("\nFormatted results from the search job as CSV\n");
        Joiner joiner = Joiner.on(",");
        List<String> fields = new ArrayList<>(resultsReader.getFields());
        System.out.println(joiner.join(fields));
        while ((event = resultsReader.getNextEvent()) != null) {
            final HashMap<String, String> row = event;
            List<String> values = Lists.transform(fields, new Function<String, String>() {
                public String apply(String field) {
                    return row.get(field);
                }
            });
            System.out.println(joiner.join(values));
        }
        resultsReader.close();
    }
}
