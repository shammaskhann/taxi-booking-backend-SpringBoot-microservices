package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.LocationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<LocationEntity,String> {
}
