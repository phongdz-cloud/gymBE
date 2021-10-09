package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.SportsManDTO;
import project.gymBE.dto.WorktimeDTO;

public interface WorktimeManagerService {

  void addSportsManForWork(String idSportMan, String idWorktime);

  WorktimeDTO addWorktimeForGym(WorktimeDTO worktimeDTO, String idGym);

  WorktimeDTO editWorktime(WorktimeDTO worktimeDTO, String id, String idGym);

  void deleteWorktime(String id);

  WorktimeDTO findWorktimeById(String id);

  List<WorktimeDTO> findWorktimesForGym(String idGym);

  List<SportsManDTO> findSportsManForWorktime(String idWorktime);

}
