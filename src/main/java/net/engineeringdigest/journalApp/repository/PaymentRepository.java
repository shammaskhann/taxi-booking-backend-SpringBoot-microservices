package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
}
