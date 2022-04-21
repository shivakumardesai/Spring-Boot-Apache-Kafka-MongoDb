package com.shiva.api;

import com.shiva.model.TelemetryData;
import com.shiva.service.TelemetryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(
		value="/api/v1/event"
)
public class TelemetryEndPoint {

	@Autowired
	TelemetryService producer;

	@GetMapping(value = "/send")
	public void sendEvent() {
            producer.send();
	}

	@GetMapping(value="/read", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TelemetryData> getData() {
		return producer.getEvents();
	}
}
