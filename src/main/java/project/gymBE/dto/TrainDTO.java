package project.gymBE.dto;

import project.gymBE.entity.Gym;
import project.gymBE.entity.Sport;

public class TrainDTO {
  private String id;
  private String name;
  // @ManyToOne
  private Sport sport;
  // @ManyToOne
  private Gym gym;

  public TrainDTO() {
  }

  public TrainDTO(String id, String name, Sport sport, Gym gym) {
    this.id = id;
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
