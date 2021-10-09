package project.gymBE.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gymBE.entity.User;
import project.gymBE.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/addUser")
  User addUser(@RequestBody User user) {
    return userService.addUser(user);
  }

  @PutMapping("/editUser/{id}")
  User editUser(@RequestBody User user, @PathVariable String id) {
    return userService.editUser(user, id);
  }

  @GetMapping("/findUserByUsername/{username}")
  Optional<User> findUserByUsername(@PathVariable String username) {
    return userService.findByUserName(username);
  }

  @DeleteMapping("/deleteUser/{id}")
  void deleteUser(@PathVariable String id) {
    userService.deleteUser(id);
  }
}
