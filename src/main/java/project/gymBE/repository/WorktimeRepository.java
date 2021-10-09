package project.gymBE.repository;

import javax.swing.Spring;
import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Worktime;

public interface WorktimeRepository extends MongoRepository<Worktime, String> {

}
