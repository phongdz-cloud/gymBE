package project.gymBE.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.entity.User;
import project.gymBE.repository.UserRepository;
import project.gymBE.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User addUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User editUser(User user, String id) {
    User existsUser = userRepository.findById(id).orElse(null);
    existsUser.setUsername(user.getUsername());
    existsUser.setPassword(user.getPassword());
    existsUser.setAdmin(user.getAdmin());
    return userRepository.save(existsUser);
  }

  @Override
  public User findUserById(String id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public Optional<User> findByUserName(String username) {
    try {
      Optional<User> user = userRepository.findUserByUsername(username);
      return user;
    }catch (Exception ex){
      System.out.println(ex.getMessage());
      return null;
    }
  }

  @Override
  public void deleteUser(String id) {
    User existUser = userRepository.findById(id).orElse(null);
    userRepository.delete(existUser);
  }
}
