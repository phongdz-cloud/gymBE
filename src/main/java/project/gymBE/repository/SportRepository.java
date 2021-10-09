package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Sport;

public interface SportRepository extends MongoRepository<Sport,String> {

}
