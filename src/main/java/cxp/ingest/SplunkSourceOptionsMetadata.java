package cxp.ingest;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * Created by markmo on 2/04/2016.
 */
public class SplunkSourceOptionsMetadata {

    private String host = "localhost";

    private int port = 8089;

    private String username = "";

    private String password = "";

    private String owner = "owner";

    private String searchQuery;

    private String earliestTime = null;

    private String latestTime = null;

    private String initEarliestTime = "@d-24h";

    private int fixedDelay = 10;

    private String fixedDelayUnit = "MINUTES";

    private String cron = "*/10 1-4 * * *";

    @NotBlank
    public String getInitEarliestTime() {
        return initEarliestTime;
    }

    @ModuleOption("the initial earliest time of the Splunk event in the search result")
    public void setInitEarliestTime(String initEarliestTime) {
        this.initEarliestTime = initEarliestTime;
    }

    @NotBlank
    public String getHost() {
        return host;
    }

    @ModuleOption("the host name or IP address of the Splunk server")
    public void setHost(String host) {
        this.host = host;
    }

    @Range(min = 0, max = 65536)
    public int getPort() {
        return port;
    }

    @ModuleOption("the TCP port number of the Splunk server")
    public void setPort(int port) {
        this.port = port;
    }

    @NotBlank
    public String getUsername() {
        return username;
    }

    @ModuleOption("the login name that has rights to receive data from Splunk")
    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank
    public String getPassword() {
        return password;
    }

    @ModuleOption("the password associated with the username")
    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
    public String getOwner() {
        return owner;
    }

    @ModuleOption("the owner of the Splunk namespace")
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @NotBlank
    public String getSearchQuery() {
        return searchQuery;
    }

    @ModuleOption("the query for Splunk Search")
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @NotBlank
    public String getEarliestTime() {
        return earliestTime;
    }

    @ModuleOption("the earliest time of the Splunk event in the search result")
    public void setEarliestTime(String earliestTime) {
        this.earliestTime = earliestTime;
    }

    @NotBlank
    public String getLatestTime() {
        return latestTime;
    }

    @ModuleOption("the latest time of the Splunk event in the search result")
    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    @Range(min = 0, max = 60)
    public int getFixedDelay() {
        return fixedDelay;
    }

    @ModuleOption("the fixed delay polling interval")
    public void setFixedDelay(int fixedDelay) {
        this.fixedDelay = fixedDelay;
    }

    @NotBlank
    public String getFixedDelayUnit() {
        return fixedDelayUnit;
    }

    @ModuleOption("the unit of time for the polling interval")
    public void setFixedDelayUnit(String fixedDelayUnit) {
        this.fixedDelayUnit = fixedDelayUnit;
    }

    @NotBlank
    public String getCron() {
        return cron;
    }

    @ModuleOption("cron schedule for the polling interval")
    public void setCron(String cron) {
        this.cron = cron;
    }
}
