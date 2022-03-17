package com.shiva.repository;

import com.shiva.model.TelemetryData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelemetryEventRepository extends MongoRepository<TelemetryData, String> {

}
