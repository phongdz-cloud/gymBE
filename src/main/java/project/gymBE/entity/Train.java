package project.gymBE.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("train")
public class Train {

  @Id
  private String id;
  private String name;
  // @ManyToOne
  private Sport sport;
  // @ManyToOne
  private Gym gym;

  public Train() {
  }

  public Train(String name, Sport sport, Gym gym) {
    this.name = name;
    this.sport = sport;
    this.gym = gym;
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

  public Sport getSport() {
    return sport;
  }

  public void setSport(Sport sport) {
    this.sport = sport;
  }

  public Gym getGym() {
    return gym;
  }

  public void setGym(Gym gym) {
    this.gym = gym;
  }
}
