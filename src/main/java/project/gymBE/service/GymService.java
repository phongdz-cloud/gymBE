package project.gymBE.service;

import project.gymBE.entity.Gym;

public interface GymService {

  Gym addGym(Gym gym);

  Gym editGym(Gym gym, Gym existsGym);
}
