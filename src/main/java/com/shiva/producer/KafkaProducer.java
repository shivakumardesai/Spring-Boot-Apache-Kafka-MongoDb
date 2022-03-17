package com.shiva.producer;

import com.shiva.event.TelemetryEvent;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class KafkaProducer {

	private final KafkaTemplate<String, TelemetryEvent> kafkaTemplate;
	private final String TOPIC = "telemetry-events";

	public KafkaProducer(KafkaTemplate<String, TelemetryEvent> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	public void sendMessage(TelemetryEvent message) {
		logger.info( "Producing message: {}", message.toString());

		ListenableFuture<SendResult<String, TelemetryEvent>> future = this.kafkaTemplate.send(TOPIC, message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, TelemetryEvent>>() {

			@Override
			public void onFailure(Throwable ex) {
				logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
			}

			@Override
			public void onSuccess(SendResult<String, TelemetryEvent> result) {
				logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
			}
		});
	}

}
