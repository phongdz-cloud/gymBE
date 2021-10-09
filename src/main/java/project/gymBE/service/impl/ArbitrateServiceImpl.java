package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.Arbitrate;
import project.gymBE.entity.Gym;
import project.gymBE.repository.ArbitrateRepository;
import project.gymBE.repository.GymRepository;
import project.gymBE.service.ArbitrateService;

@Service
public class ArbitrateServiceImpl implements ArbitrateService {

  @Autowired
  private ArbitrateRepository arbitrateRepository;
  @Autowired
  private GymRepository gymRepository;

  @Override
  public Arbitrate addArbitrateForGym(Arbitrate arbitrate, Gym gym) {
    gym.getArbitrates().add(arbitrate);
    arbitrate.setIdGym(gym.getId());
    gymRepository.save(gym);
    return arbitrateRepository.save(arbitrate);
  }

  @Override
  public Arbitrate editArbitrate(Arbitrate arbitrate, Arbitrate existArbitrate) {
    existArbitrate.setName(arbitrate.getName());
    existArbitrate.setIdGym(arbitrate.getIdGym());
    existArbitrate.setIdSport(arbitrate.getIdSport());
    return arbitrateRepository.save(existArbitrate);
  }

  @Override
  public void delete(Arbitrate existsArbitrate) {
    arbitrateRepository.delete(existsArbitrate);
  }
}
