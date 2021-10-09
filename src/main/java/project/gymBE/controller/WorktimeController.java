package project.gymBE.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gymBE.dto.SportsManDTO;
import project.gymBE.dto.WorktimeDTO;
import project.gymBE.manager.WorktimeManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class WorktimeController {

  @Autowired
  private WorktimeManagerService worktimeManagerService;

  @PostMapping("/addSportsManForWork/{idSprtsMan}/{idWorktime}")
  void addSportsManForWork(@PathVariable String idSprtsMan, @PathVariable String idWorktime) {
    worktimeManagerService.addSportsManForWork(idSprtsMan, idWorktime);
  }

  @PutMapping("/editWorktime/{id}/{idGym}")
  WorktimeDTO editWorktime(@RequestBody WorktimeDTO worktime, @PathVariable String id,
      @PathVariable String idGym) {
    return worktimeManagerService.editWorktime(worktime, id, idGym);
  }

  @DeleteMapping("/deleteWorktime/{id}")
  void deleteWorktime(@PathVariable String id) {
    worktimeManagerService.deleteWorktime(id);
  }

  @GetMapping("/findWorktimesForGym/{idGym}")
  List<WorktimeDTO> findWorktimesForGym(@PathVariable String idGym) {
    return worktimeManagerService.findWorktimesForGym(idGym);
  }

  @GetMapping("/findSportsManForWorktime/{idWorktime}")
  List<SportsManDTO> findSportsManForWorktime(@PathVariable String idWorktime) {
    return worktimeManagerService.findSportsManForWorktime(idWorktime);
  }
}
