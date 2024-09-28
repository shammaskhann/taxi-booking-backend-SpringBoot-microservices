package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity,String> {

    Optional<CustomerEntity> findByEmail(String email);
}
