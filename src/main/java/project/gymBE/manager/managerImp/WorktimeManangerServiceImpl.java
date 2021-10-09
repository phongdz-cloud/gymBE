package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.SportsManDTO;
import project.gymBE.dto.WorktimeDTO;
import project.gymBE.entity.Gym;
import project.gymBE.entity.SportsMan;
import project.gymBE.entity.Worktime;
import project.gymBE.manager.WorktimeManagerService;
import project.gymBE.repository.GymRepository;
import project.gymBE.repository.SportsManRepository;
import project.gymBE.repository.WorktimeRepository;
import project.gymBE.service.WorktimeService;

@Transactional
@Service
public class WorktimeManangerServiceImpl implements WorktimeManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private WorktimeRepository worktimeRepository;
  @Autowired
  private WorktimeService worktimeService;
  @Autowired
  private GymRepository gymRepository;
  @Autowired
  private SportsManRepository sportsManRepository;

  @Override
  public void addSportsManForWork(String idSportMan, String idWorktime) {
    SportsMan sportsMan = sportsManRepository.findById(idSportMan).orElse(null);
    Worktime worktime = worktimeRepository.findById(idWorktime).orElse(null);
    worktime.getSportsMEN().add(sportsMan);
  }

  @Override
  public WorktimeDTO addWorktimeForGym(WorktimeDTO worktimeDTO, String idGym) {
    Gym gym = gymRepository.findById(idGym).orElse(null);
    Worktime worktime = modelMapper.map(worktimeDTO, Worktime.class);
    return modelMapper.map(worktimeService.addWorktimeForGym(worktime, gym), WorktimeDTO.class);
  }

  @Override
  public WorktimeDTO editWorktime(WorktimeDTO worktimeDTO, String id, String idGym) {
    Worktime worktime = modelMapper.map(worktimeDTO, Worktime.class);
    Worktime existsWorktime = worktimeRepository.findById(id).orElse(null);
    Gym gym = gymRepository.findById(idGym).orElse(null);
    return modelMapper.map(worktimeService.editWorktime(worktime, existsWorktime, gym),
        WorktimeDTO.class);
  }

  @Override
  public void deleteWorktime(String id) {
    Worktime existsWorktime = worktimeRepository.findById(id).orElse(null);
    worktimeRepository.delete(existsWorktime);
  }

  @Override
  public WorktimeDTO findWorktimeById(String id) {
    return modelMapper.map(worktimeRepository.findById(id).orElse(null), WorktimeDTO.class);
  }

  @Override
  public List<WorktimeDTO> findWorktimesForGym(String idGym) {
    Gym gym = gymRepository.findById(idGym).orElse(null);
    List<Worktime> worktimes = gym.getWorktimes();
    return worktimes.stream().map(worktime -> modelMapper.map(worktime, WorktimeDTO.class)).collect(
        Collectors.toList());
  }

  @Override
  public List<SportsManDTO> findSportsManForWorktime(String idWorktime) {
    Worktime worktime = worktimeRepository.findById(idWorktime).orElse(null);
    List<SportsMan> sportsMans = worktime.getSportsMEN();
    return sportsMans.stream().map(sportsMan -> modelMapper.map(sportsMan, SportsManDTO.class))
        .collect(
            Collectors.toList());
  }
}
