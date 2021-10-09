package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.SportsManDTO;

public interface SportsManManagerService {

  SportsManDTO addSportsMan(SportsManDTO sportsManDTO);

  SportsManDTO editSportsMan(SportsManDTO sportsManDTO, String id);

  void deleteSportsMan(String id);

  SportsManDTO findSportsManById(String id);

  List<SportsManDTO> findAllSportsMans();
}
