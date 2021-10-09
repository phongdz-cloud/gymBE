package project.gymBE.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

  Optional<User> findUserByUsername(String username);
}
