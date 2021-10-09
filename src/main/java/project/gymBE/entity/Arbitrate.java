package project.gymBE.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("arbitrate")
public class Arbitrate {

  @Id
  private String id;
  private String name;
  //  private SportDTO sport;
  private String idSport;
  // @ManyToOne
//  private GymDTO gym;
  private String idGym;

  public Arbitrate() {
  }

  public Arbitrate(String id, String name, String idSport, String idGym) {
    this.id = id;
    this.name = name;
    this.idSport = idSport;
    this.idGym = idGym;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdSport() {
    return idSport;
  }

  public void setIdSport(String idSport) {
    this.idSport = idSport;
  }

  public String getIdGym() {
    return idGym;
  }

  public void setIdGym(String idGym) {
    this.idGym = idGym;
  }
}
