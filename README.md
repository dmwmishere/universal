# Dank system
Simple application 2 plei wiz camel stuff 2 request meme information from database.
Each system placed in separate module consisting of set of processors and context file with route definitions.

Usage:
java -jar Main-1.0-SNAPSHOT.jar

1. core - common stuff (utils, stats etc.)
2. sys1 - sends meme requests to sys2 (SOAP --> file + JMS/ActiveMq)
3. sys2 - retrieves information about a meme from database (HSQLDB) and sends it back to sys1 by JMQ

## Features:
* Maven. Uses separate modules for different systems
* Springframework (beans, injections, jdbc)
* Property files
* Camel (cxf/jms/log/threads/timers/file)
* cxf (sys1)
* Log4j (multiple files config)
* AOP (logging, response time)
* Sending stats to influxdb (tps, response time)
* Web-application module 2 run in web-container
* Embedded Jolokia agent as servlet
* Junit tests for util classes and camel routes


## TODO:
* Hibernate support 
* Cucumber scenarios

## FIX:
* Investigate bottlenecks
* JMS response correlations (RqUID)
