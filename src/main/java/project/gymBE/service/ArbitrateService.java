package project.gymBE.service;

import project.gymBE.entity.Arbitrate;
import project.gymBE.entity.Gym;

public interface ArbitrateService {

  Arbitrate addArbitrateForGym(Arbitrate arbitrate, Gym gym);

  Arbitrate editArbitrate(Arbitrate arbitrate, Arbitrate existArbitrate);

  void delete(Arbitrate existsArbitrate);
}
