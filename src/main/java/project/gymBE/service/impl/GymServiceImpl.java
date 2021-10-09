package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.Gym;
import project.gymBE.repository.GymRepository;
import project.gymBE.service.GymService;

@Service
public class GymServiceImpl implements GymService {

  @Autowired
  private GymRepository gymRepository;

  @Override
  public Gym addGym(Gym gym) {
    return gymRepository.save(gym);
  }

  @Override
  public Gym editGym(Gym gym, Gym existsGym) {
    existsGym.setName(gym.getName());
    existsGym.setAddress(gym.getAddress());
    existsGym.setArea(gym.getArea());
    existsGym.setCity(gym.getCity());
    existsGym.setLogo(gym.getLogo());
    return gymRepository.save(existsGym);
  }
}
