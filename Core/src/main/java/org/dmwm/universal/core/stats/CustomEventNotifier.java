package org.dmwm.universal.core.stats;

import java.util.EventObject;

import org.apache.camel.management.event.ExchangeSentEvent;
import org.apache.camel.support.EventNotifierSupport;
import org.springframework.stereotype.Component;

@Component
public class CustomEventNotifier extends EventNotifierSupport {

	@Override
	public void notify(EventObject event) throws Exception {
		if (event instanceof ExchangeSentEvent) {
            ExchangeSentEvent sent = (ExchangeSentEvent) event;
            log.info("Took " + sent.getTimeTaken() + " millis to send to: " + sent.getEndpoint());
        }
	}

	@Override
	public boolean isEnabled(EventObject event) {
		return event instanceof ExchangeSentEvent;
	}

}
