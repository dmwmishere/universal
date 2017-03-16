package org.dmwm.universal.main;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelTest {

	private static final Logger log = Logger.getLogger(CamelTest.class);

	public static void main(String[] args) throws Exception {
		log.info("STARTING THE APP...");
		log.warn("Required systems (docker containers): activemq(activemq), hsqldb(chsqldb), kafka(ckafka), influx (cinflux)");
		System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");
		System.setProperty("java.security.auth.login.config",
				"/external/kafka_krb/kafka_client_jaas.conf");
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			log.info("DONE WITH SPRING " + appContext.getId().hashCode() + ".");

			while (true) {
				Thread.sleep(5000);
			}
		}
	}
}