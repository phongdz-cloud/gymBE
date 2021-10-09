package project.gymBE.service;

import project.gymBE.entity.Gym;
import project.gymBE.entity.Sport;

public interface SportService {
  Sport addSport(Sport sport, Gym gym);

  Sport editSport(Sport sport, Sport existSport);
}
