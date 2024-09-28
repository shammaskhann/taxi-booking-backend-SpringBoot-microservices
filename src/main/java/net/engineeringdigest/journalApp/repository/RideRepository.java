package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.RideEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RideRepository extends MongoRepository<RideEntity,String> {
}
