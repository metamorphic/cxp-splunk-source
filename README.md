## cxp-splunk-source

A custom Spring XD source for Splunk.

### Setting up a development environment

Setup a local instance of Splunk for testing. Download Splunk from [their site](http://www.splunk.com/en_us/download-5.html). Further instructions can be found [here](http://docs.splunk.com/Documentation/Splunk/6.4.0/SearchTutorial/Systemrequirements).

Start Splunk according to the instructions on the website.

Login to Splunk and navigate to 'Add Data'. Click on 'upload' files from my computer. Select the test file from src/test/resources/test_events.raw.

We should now be able to use the Splunk REST API. Execute a query using the credentials you provided during installation.

    curl -k -u admin:password https://localhost:8089/services/search/jobs -d search="search *"

This will return a job id, e.g.:

    <?xml version="1.0" encoding="UTF-8"?>
    <response>
      <sid>1460542925.8</sid>
    </response>

You can get the status of the job by navigating to:

    curl -k -u <username>:<password> https://localhost:8089/services/search/jobs/1460542925.8

(I would expect the job to finish fairly quickly using the test set.)

Use the job id to get the results once the job completes.

    curl -k -u <username>:<password> https://localhost:8089/services/search/jobs/1460542925.8/results/ --get -d output_mode=raw

If you get JSON output, everything is working. We can test Spring XD by calling this service.

Setup an HDFS instance, e.g. Hortonworks. The Hortonworks [HDP 2.4 Sandbox](http://hortonworks.com/downloads/) on VirtualBox is probably the easiest path.

The HDFS namenode will be a parameter on the Spring XD stream.


### Building the project

To build the project:

    ./gradlew clean build

Spring XD deployable JAR created under build/libs/cxp-splunk-source-1.0.jar

Start xd-shell

Issue the following commands in the shell:

    module upload --type source --name splunk --file ./build/libs/cxp-splunk-source-1.0.jar

    stream create --name splunktest --definition "splunk --host=<host> --username=<username> --password=<password> --owner=<owner> --savedSearch=<saved-search> --fixedDelay=<fixed-delay> --fixedDelayUnit=<fixed-delay-unit> | log" --deploy

To stream to a parquet file on HDFS:

    stream create --name splunktest --definition "splunk --host=localhost --username=<username> --password=<password> --owner=<owner> --savedSearch=www1_access_20160331PM --fixedDelay=5 --fixedDelayUnit=SECONDS | hdfs-dataset --format=parquet --fsUri='hdfs://localhost:9000'" --deploy

Module options include:

    Option Name     Description                                                 Default    Type
    --------------  ----------------------------------------------------------  ---------  ---------------------------------
    fixedDelay      the fixed delay polling interval                            5          int
    fixedDelayUnit  the unit of time for the polling interval                   HOURS      java.lang.String
    host            the host name or IP address of the Splunk server            localhost  java.lang.String
    owner           the owner of the Splunk namespace                           owner      java.lang.String
    password        the password associated with the username                   password   java.lang.String
    port            the TCP port number of the Splunk server                    8089       int
    savedSearch     the name of the saved search in Splunk                      <none>     java.lang.String
    username        the login name that has rights to receive data from Splunk  admin      java.lang.String

### Running Unit Tests

    ./gradlew test

The test report can be found at 'build/reports/tests/index.html'.

### Dependencies

* [spring-integration-splunk](https://github.com/markmo/spring-integration-splunk)
* [Guava](https://github.com/google/guava) V19.0
* [jackson-databind](https://github.com/FasterXML/jackson-databind) V2.7.0
