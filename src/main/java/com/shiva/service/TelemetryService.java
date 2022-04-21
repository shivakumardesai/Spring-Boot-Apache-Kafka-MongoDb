package com.shiva.service;

import com.shiva.event.TelemetryEvent;
import com.shiva.model.TelemetryData;

import java.util.List;

public interface TelemetryService {
	  void send();

	void save(TelemetryEvent event);

	  List<TelemetryData> getEvents();
}
