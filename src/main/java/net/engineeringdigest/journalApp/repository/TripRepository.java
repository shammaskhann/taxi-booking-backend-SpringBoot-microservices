package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.TripEntity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TripRepository extends MongoRepository<TripEntity,String> {
}
