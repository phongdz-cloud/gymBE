package project.gymBE.dto;

import java.util.ArrayList;
import java.util.List;
import project.gymBE.entity.Payment;
import project.gymBE.entity.Sport;
import project.gymBE.entity.Worktime;

public class SportsManDTO {
  private String id;
  private String firstName;
  private String lastName;
  private int age;
  private String sex;
  private String avatar;
  // @ManyToOne
  private Worktime worktime;
  // @OneToMany
  private List<Sport> sports = new ArrayList<>();
  // @OneToMany
  private List<Payment> payments = new ArrayList<>();

  public SportsManDTO() {
  }

  public SportsManDTO(String id, String firstName, String lastName, int age, String sex,
      String avatar, Worktime worktime, List<Sport> sports,
      List<Payment> payments) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.sex = sex;
    this.avatar = avatar;
    this.worktime = worktime;
    this.sports = sports;
    this.payments = payments;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Worktime getWorktime() {
    return worktime;
  }

  public void setWorktime(Worktime worktime) {
    this.worktime = worktime;
  }

  public List<Sport> getSports() {
    return sports;
  }

  public void setSports(List<Sport> sports) {
    this.sports = sports;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }
}
