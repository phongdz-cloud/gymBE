package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Gym;

public interface GymRepository extends MongoRepository<Gym,String> {

}
