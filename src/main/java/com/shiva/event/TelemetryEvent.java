package com.shiva.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class TelemetryEvent implements Serializable {

	private String id;

	private String name;

	private String description;

	private Long versionId;

	private Double latitude;

	private Double longitude;

	private Double altitude;

	private Double speed;

	private boolean direction;

	private Timestamp timestamp;

	public TelemetryEvent(String id, String name, String description, Long versionId, Double latitude, Double longitude,
			Double altitude, Double speed, boolean direction, Timestamp timestamp) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.versionId = versionId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
		this.speed = speed;
		this.direction = direction;
		this.timestamp = timestamp;
	}

	public TelemetryEvent() {
	}
}
