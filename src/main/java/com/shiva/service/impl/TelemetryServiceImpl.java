package com.shiva.service.impl;

import com.shiva.event.TelemetryEvent;
import com.shiva.mapper.TelemetryMapper;
import com.shiva.model.TelemetryData;
import com.shiva.producer.KafkaProducer;
import com.shiva.repository.TelemetryEventRepository;
import com.shiva.service.TelemetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Service
public class TelemetryServiceImpl implements TelemetryService {

	@Autowired
	KafkaProducer producer;

	@Autowired
	TelemetryMapper mapper;

	@Autowired
	TelemetryEventRepository telemetryEventRepository;

	@Override
	public void send() {
		for (int i = 0; i < 500000; i++) {
			TelemetryEvent te = new TelemetryEvent(
					"1"+i,
					"Event"+i,
					"Telemtry Event"+i,
					(long) i,
					(double) i,
					(double) i,
					(double) i,
					(double) i,
					i%2==1 ? true : false ,
					new Timestamp(System.currentTimeMillis()));

			producer.sendMessage(te);
		}
	}

	@Override
	public void save(TelemetryEvent event) {
		TelemetryData td= telemetryEventRepository.save(mapper.mapEventToCollection(event));
        logger.info("Saved Telemetry Data with Id "+td.getId());
	}
	@Override
	public List<TelemetryData> getEvents() {
		Pageable secondPageWithFiveElements = PageRequest.of(0, 500);
		return telemetryEventRepository.findAll(secondPageWithFiveElements).getContent();
	}

}
