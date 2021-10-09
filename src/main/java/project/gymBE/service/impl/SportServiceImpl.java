package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Sport;
import project.gymBE.repository.GymRepository;
import project.gymBE.repository.SportRepository;
import project.gymBE.service.SportService;

@Service
public class SportServiceImpl implements SportService {

  @Autowired
  private SportRepository sportRepository;

  @Autowired
  private GymRepository gymRepository;

  @Override
  public Sport addSport(Sport sport, Gym gym) {
    gym.getSports().add(sport);
    gymRepository.save(gym);
    return sportRepository.save(sport);
  }

  @Override
  public Sport editSport(Sport sport, Sport existSport) {
    existSport.setName(sport.getName());
    existSport.setDescription(sport.getDescription());
    existSport.setPhoto(sport.getPhoto());
    return sportRepository.save(existSport);
  }
}
