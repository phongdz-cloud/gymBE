package project.gymBE.entity;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("payment")
public class Payment {

  @Id
  private String id;
  private Double cost;
  @Temporal(TemporalType.TIMESTAMP)
  private Date date;
  private String duration;
  // @ManyToOne
  private SportsMan sportsMan;

  public Payment() {
  }

  public Payment(Double cost, Date date, String duration, SportsMan sportsMan) {
    this.cost = cost;
    this.date = date;
    this.duration = duration;
    this.sportsMan = sportsMan;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public SportsMan getSportsMan() {
    return sportsMan;
  }

  public void setSportsMan(SportsMan sportsMan) {
    this.sportsMan = sportsMan;
  }
}
