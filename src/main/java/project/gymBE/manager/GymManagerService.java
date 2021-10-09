package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.GymDTO;

public interface GymManagerService {

  GymDTO addGym(GymDTO gymDTO);

  GymDTO editGym(GymDTO gymDTO, String id);

  void deleteGym(String id);

  GymDTO findGymById(String id);

  List<GymDTO> findAllGyms();
}
