package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.CarEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<CarEntity, String> {
}
