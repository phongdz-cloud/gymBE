package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.SportsMan;
import project.gymBE.repository.SportsManRepository;
import project.gymBE.service.SportsManService;

@Service
public class SportsManImpl implements SportsManService {

  @Autowired
  private SportsManRepository sportsManRepository;

  @Override
  public SportsMan addSportsMan(SportsMan sportsMan) {
    return sportsManRepository.save(sportsMan);
  }

  @Override
  public SportsMan editSportsMan(SportsMan sportsMan, SportsMan existSportsMan) {
    existSportsMan.setFirstName(sportsMan.getFirstName());
    existSportsMan.setLastName(sportsMan.getLastName());
    existSportsMan.setAge(sportsMan.getAge());
    existSportsMan.setSex(sportsMan.getSex());
    existSportsMan.setAvatar(sportsMan.getAvatar());
    return sportsManRepository.save(existSportsMan);
  }
}
