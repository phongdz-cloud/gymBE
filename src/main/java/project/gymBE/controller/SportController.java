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
import project.gymBE.dto.SportDTO;
import project.gymBE.manager.SportManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class SportController {

  @Autowired
  private SportManagerService sportManagerService;

  @PostMapping("/addSportForGym/{idGym}")
  SportDTO addSportForGym(@RequestBody SportDTO sport, @PathVariable String idGym) {
    return sportManagerService.addSportForGym(sport, idGym);
  }

  @PostMapping("/addSportForSportsMan/{idSport}/{idSportsMan}")
  void addSportForSportsMan(@PathVariable String idSport, @PathVariable String idSportsMan) {
    sportManagerService.addSportForSportsMan(idSport, idSportsMan);
  }

  @PutMapping("/editSport/{id}")
  SportDTO editSport(@RequestBody SportDTO sport, @PathVariable String id) {
    return sportManagerService.editSport(sport, id);
  }

  @DeleteMapping("/deleteSport/{id}")
  void deleteSport(@PathVariable String id) {
    sportManagerService.deleteSport(id);
  }

  @GetMapping("/findSportById/{id}")
  SportDTO findSportById(@PathVariable String id) {
    return sportManagerService.findSportById(id);
  }

  @GetMapping("/findSportsForSportsMan/{idSportsMan}")
  List<SportDTO> findSportsForSportsMan(@PathVariable String idSportsMan) {
    return sportManagerService.findSportsForSportsMan(idSportsMan);
  }

  @GetMapping("/findSportsForGym/{idGym}")
  List<SportDTO> findSportsForGym(@PathVariable String idGym) {
    return sportManagerService.findSportsForGym(idGym);
  }
}
