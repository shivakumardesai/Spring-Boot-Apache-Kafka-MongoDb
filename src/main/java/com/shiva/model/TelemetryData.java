package com.shiva.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Document(collection = "telemetry_data")
public class TelemetryData {

	@Id
	private String id;

	@Field("eventId")
	private String eventId;

	@Field("name")
	private String name;

	@Field("description")
	private String description;

	@Field("versionId")
	private Long versionId;

	@Field("latitude")
	private Double latitude;

	@Field("longitude")
	private Double longitude;

	@Field("altitude")
	private Double altitude;

	@Field("speed")
	private Double speed;

	@Field("direction")
	private boolean direction;

	@Field("timestamp")
	private Date timestamp;

}
