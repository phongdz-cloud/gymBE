package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Worktime;
import project.gymBE.repository.WorktimeRepository;
import project.gymBE.service.WorktimeService;

@Service
public class WorktimeServiceImpl implements WorktimeService {

  @Autowired
  private WorktimeRepository worktimeRepository;

  @Override
  public Worktime addWorktimeForGym(Worktime worktime, Gym gym) {
    gym.getWorktimes().add(worktime);
    return worktimeRepository.save(worktime);
  }

  @Override
  public Worktime editWorktime(Worktime worktime, Worktime existWorktime, Gym gym) {
    existWorktime.setDay(worktime.getDay());
    existWorktime.setTimetable(worktime.getTimetable());
    existWorktime.setEnd(worktime.getEnd());
    existWorktime.setStart(worktime.getStart());
    gym.getWorktimes().add(existWorktime);
    return worktimeRepository.save(existWorktime);
  }
}
