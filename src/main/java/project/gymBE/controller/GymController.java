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
import project.gymBE.dto.GymDTO;
import project.gymBE.manager.GymManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class GymController {

  @Autowired
  private GymManagerService gymManagerService;

  @PostMapping("/addGym")
  GymDTO addGym(@RequestBody GymDTO gym) {
    return gymManagerService.addGym(gym);
  }

  @PutMapping("/editGym/{id}")
  GymDTO editGym(@RequestBody GymDTO gym, @PathVariable String id) {
    return gymManagerService.editGym(gym, id);
  }

  @DeleteMapping("/deleteGym/{id}")
  void deleteGym(@PathVariable String id) {
    gymManagerService.deleteGym(id);
  }

  @GetMapping("/findGymById/{id")
  GymDTO findGymById(@PathVariable String id) {
    return gymManagerService.findGymById(id);
  }

  @GetMapping("/findAllGyms")
  List<GymDTO> findAllGyms() {
    return gymManagerService.findAllGyms();
  }
}
