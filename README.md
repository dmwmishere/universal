# Dank system

Simple application 2 plei wiz camel stuff 2 request meme information from database.

1. core - common stuff (utils, stats etc.)
2. sys1 - sends meme requests to sys2 (SOAP --> file + JMS/ActiveMq)
3. sys2 - retrieves information about a meme from database (HSQLDB) and sends it back to sys1 by JMQ

## Features:
* Maven
* Springframework (beans, injections, jdbc)
* Property files
* Camel (cxf/jms/log/threads/timers/file)
* cxf (sys1)
* Log4j (multiple files config)
* AOP (logging, response time)
* Sending stats to influxdb (tps, response time)

## TODO:
1. Split systems (sys1, sys2, ...) by maven modules
2. Put stats into database and later insert into influx
3. Split camel routes to separate files
4. Add memes by calling sys1 service and sending soap-request to sys2

## FIX 1:
* Investigate bottlenecks
* JMS response correlations (RqUID)
