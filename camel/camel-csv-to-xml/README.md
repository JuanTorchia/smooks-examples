About this example
==================
 	This is an example that illustrates the usage of SmooksComponent

    See:
        1. The "Main" class in src/main/java/example/Main.java.
        2. The input message in input-message.csv.
        3. smooks-config.xml.

How to Run?
===========
    Requirements:
        1. JDK 1.5
        2. Maven 2.x (http://maven.apache.org/download.html)

    Running:
        1. "mvn clean install"
        2. "mvn exec:java"

Run in Servicemix 4.2
=====================

Install and configure Servicemix 4.x
--------------------------------------
1. Install Servicemix 4.x (http://servicemix.apache.org/servicemix-420.html)
2. Start Servicemix:
    ${SERVICEMIX_HOME}/bin/servicemix
3. tail -f ${SERVICEMIX_HOME}/data/log/servicemix.log


Deploy Smooks OSGi Bundle
-------------------------
1. Deploy Smooks OSGi bundle
    karaf@root> features:addUrl  file:///path/to/smooks/smooks-all/target/classes/features.xml
    karaf@root> features:install smooks

2. Deploy the example
    osgi:install -s mvn:org.smooks/milyn-smooks-example-camel-csv-to-xml/1.6-SNAPSHOT

Run the example
---------------
1. cp input-message.csv input-dir
2. check ${SERVICEMIX_HOME}/data/log/servicemix.log for the log messages

