package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Arbitrate;

public interface ArbitrateRepository extends MongoRepository<Arbitrate,String> {

}
