package project.gymBE.service;

import java.util.Optional;
import project.gymBE.entity.User;

public interface UserService {

  User addUser(User user);

  User editUser(User user, String id);

  User findUserById(String id);

  Optional<User> findByUserName(String username);

  void deleteUser(String id);
}
