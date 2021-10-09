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
import project.gymBE.manager.SportsManManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class SportsManController {

  @Autowired
  private SportsManManagerService sportsManManagerService;

  @PostMapping("/addSportsMan/{id}")
  SportsManDTO addSportsMan(@RequestBody SportsManDTO sportsMan) {
    return sportsManManagerService.addSportsMan(sportsMan);
  }

  @PutMapping("/editSportsMan/{id}")
  SportsManDTO editSportsMan(@RequestBody SportsManDTO sportsMan, @PathVariable String id) {
    return sportsManManagerService.editSportsMan(sportsMan, id);
  }

  @DeleteMapping("/deleteSportsMan/{id}")
  void deleteSportsMan(@PathVariable String id) {
    sportsManManagerService.deleteSportsMan(id);
  }

  @GetMapping("/findSportsManById/{id}")
  SportsManDTO findSportsManById(@PathVariable String id) {
    return sportsManManagerService.findSportsManById(id);
  }

  @GetMapping("/findAllSportsMans")
  List<SportsManDTO> findAllSportsMans() {
    return sportsManManagerService.findAllSportsMans();
  }
}
