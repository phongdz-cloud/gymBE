package project.gymBE.service;

import project.gymBE.entity.SportsMan;

public interface SportsManService {

  SportsMan addSportsMan(SportsMan sportsMan);

  SportsMan editSportsMan(SportsMan sportsMan, SportsMan existSportsMan);

}
