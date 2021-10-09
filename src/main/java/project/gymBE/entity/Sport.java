package project.gymBE.entity;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sport")
public class Sport {

  @Id
  private String id;
  private String name;
  private String description;
  private String photo;
  // @ManyToOne
  private SportsMan sportsMan;
  // @ManyToOne
  private String idGym;
  // @OneToMany
  private List<Arbitrate> arbitrates = new ArrayList<>();
  // @OneToMany
  private List<Train> trains = new ArrayList<>();

  public Sport() {
  }

  public Sport(String id, String name, String description, String photo,
      SportsMan sportsMan, String idGym, List<Arbitrate> arbitrates,
      List<Train> trains) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.photo = photo;
    this.sportsMan = sportsMan;
    this.idGym = idGym;
    this.arbitrates = arbitrates;
    this.trains = trains;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public SportsMan getSportsMan() {
    return sportsMan;
  }

  public void setSportsMan(SportsMan sportsMan) {
    this.sportsMan = sportsMan;
  }

  public String getIdGym() {
    return idGym;
  }

  public void setIdGym(String idGym) {
    this.idGym = idGym;
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
}