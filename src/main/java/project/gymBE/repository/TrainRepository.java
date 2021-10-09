package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Train;

public interface TrainRepository extends MongoRepository<Train,String> {

}
