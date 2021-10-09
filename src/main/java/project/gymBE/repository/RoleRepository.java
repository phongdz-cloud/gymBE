package project.gymBE.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.gymBE.entity.Role;

public interface RoleRepository extends MongoRepository<Role,String> {

}
