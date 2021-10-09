package project.gymBE.dto;

import java.util.Date;
import project.gymBE.entity.SportsMan;

public class PaymentDTO {
  private String id;
  private Double cost;
  private Date date;
  private String duration;
  // @ManyToOne
  private SportsMan sportsMan;

  public PaymentDTO() {
  }

  public PaymentDTO(String id, Double cost, Date date, String duration,
      SportsMan sportsMan) {
    this.id = id;
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
