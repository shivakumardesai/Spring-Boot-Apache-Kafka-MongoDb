package com.shiva.consumer;

import com.shiva.event.TelemetryEvent;
import com.shiva.service.TelemetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

	@Autowired
	TelemetryService telemetryService;

	private final String TOPIC = "telemetry-events";

	@KafkaListener(topics = TOPIC, groupId = "TelemetryEvent_cg")
	public void listen(TelemetryEvent event) {
		telemetryService.save(event);
	}


}
