package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.SportDTO;

public interface SportManagerService {
  SportDTO addSportForGym(SportDTO sportDTO, String idGym);

  void addSportForSportsMan(String idSport, String idSportsMan);

  SportDTO editSport(SportDTO sportDTO,String id);

  void deleteSport(String id);

  SportDTO findSportById(String id);

  List<SportDTO> findSportsForSportsMan(String idSportsMan);

  List<SportDTO> findSportsForGym(String idGym);
}
