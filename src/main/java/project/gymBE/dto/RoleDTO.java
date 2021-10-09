package project.gymBE.dto;

import project.gymBE.entity.RoleName;

public class RoleDTO {

  private String id;
  private RoleName name;

  public RoleDTO() {
  }

  public RoleDTO(String id, RoleName name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RoleName getName() {
    return name;
  }

  public void setName(RoleName name) {
    this.name = name;
  }
}
