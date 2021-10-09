package project.gymBE.service;

import project.gymBE.entity.Gym;
import project.gymBE.entity.Worktime;

public interface WorktimeService {

  Worktime addWorktimeForGym(Worktime worktime, Gym gym);

  Worktime editWorktime(Worktime worktime, Worktime existWorktime, Gym gym);
}
