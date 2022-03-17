package com.shiva.mapper;

import com.shiva.event.TelemetryEvent;
import com.shiva.model.TelemetryData;
import org.springframework.stereotype.Component;

@Component
public class TelemetryMapper {

	public TelemetryData mapEventToCollection(TelemetryEvent event) {
		TelemetryData td = new TelemetryData();
		td.setEventId(event.getId());
		td.setName(event.getName());
		td.setDescription(event.getDescription());
		td.setSpeed( event.getSpeed());
		td.setDirection(event.isDirection());
		td.setLatitude(event.getLatitude());
		td.setLongitude(event.getLongitude());
		td.setAltitude(event.getAltitude());
		td.setVersionId(event.getVersionId());
        td.setTimestamp(event.getTimestamp());
		return td;
	}
}
