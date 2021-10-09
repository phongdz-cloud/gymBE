package project.gymBE.dto;

import java.util.Date;
import java.util.List;
import project.gymBE.entity.Gym;
import project.gymBE.entity.SportsMan;

public class WorktimeDTO {

  private String id;
  private String day;
  private Date timetable;
  private String start;
  private String end;
  // @ManyToOne
  private Gym gym;
  // OneToMany
  private List<SportsMan> sportsMEN;

  public WorktimeDTO() {
  }

  public WorktimeDTO(String id, String day, Date timetable, String start, String end,
      Gym gym, List<SportsMan> sportsMEN) {
    this.id = id;
    this.day = day;
    this.timetable = timetable;
    this.start = start;
    this.end = end;
    this.gym = gym;
    this.sportsMEN = sportsMEN;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDay() {
    return day;
  }

  public void setDay(String day) {
    this.day = day;
  }

  public Date getTimetable() {
    return timetable;
  }

  public void setTimetable(Date timetable) {
    this.timetable = timetable;
  }

  public String getStart() {
    return start;
  }

  public void setStart(String start) {
    this.start = start;
  }

  public String getEnd() {
    return end;
  }

  public void setEnd(String end) {
    this.end = end;
  }

  public Gym getGym() {
    return gym;
  }

  public void setGym(Gym gym) {
    this.gym = gym;
  }

  public List<SportsMan> getSportsMEN() {
    return sportsMEN;
  }

  public void setSportsMEN(List<SportsMan> sportsMEN) {
    this.sportsMEN = sportsMEN;
  }
}
