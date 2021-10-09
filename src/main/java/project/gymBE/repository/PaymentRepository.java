package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}
