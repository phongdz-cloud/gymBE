package project.gymBE.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("gym")
public class Gym {

  @Id
  private String id;
  private String name;
  private String address;
  private String city;
  private int area;
  private String logo;
  // @OneToMany
  private List<Worktime> worktimes = new ArrayList<>();
  // @OneToMany
  private List<Arbitrate> arbitrates = new ArrayList<>();
  // @OneToMany
  private List<Train> trains = new ArrayList<>();
  private List<Sport> sports = new ArrayList<>();

  public Gym() {
  }

  public Gym(String id, String name, String address, String city, int area, String logo,
      List<Worktime> worktimes, List<Arbitrate> arbitrates,
      List<Train> trains, List<Sport> sports) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.city = city;
    this.area = area;
    this.logo = logo;
    this.worktimes = worktimes;
    this.arbitrates = arbitrates;
    this.trains = trains;
    this.sports = sports;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getArea() {
    return area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public String getLogo() {
    return logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }

  public List<Worktime> getWorktimes() {
    return worktimes;
  }

  public void setWorktimes(List<Worktime> worktimes) {
    this.worktimes = worktimes;
  }

  public List<Arbitrate> getArbitrates() {
    return arbitrates;
  }

  public void setArbitrates(List<Arbitrate> arbitrates) {
    this.arbitrates = arbitrates;
  }

  public List<Train> getTrains() {
    return trains;
  }

  public void setTrains(List<Train> trains) {
    this.trains = trains;
  }

  public List<Sport> getSports() {
    return sports;
  }

  public void setSports(List<Sport> sports) {
    this.sports = sports;
  }
}
