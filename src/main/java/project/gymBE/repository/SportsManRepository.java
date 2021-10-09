package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.SportsMan;

public interface SportsManRepository extends MongoRepository<SportsMan, String> {

}
