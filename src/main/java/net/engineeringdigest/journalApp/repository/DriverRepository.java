package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.DriverEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<DriverEntity, String> {
}
