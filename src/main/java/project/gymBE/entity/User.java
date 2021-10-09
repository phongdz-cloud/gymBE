package project.gymBE.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

  @Id
  private String id;
  private String username;
  private String password;
  private Boolean isAdmin;

  public User() {
  }

  public User(String id, String username, String password, Boolean isAdmin) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getAdmin() {
    return isAdmin;
  }

  public void setAdmin(Boolean admin) {
    isAdmin = admin;
  }
}
