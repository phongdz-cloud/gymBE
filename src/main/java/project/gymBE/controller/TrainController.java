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
import project.gymBE.dto.TrainDTO;
import project.gymBE.manager.TrainManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class TrainController {

  @Autowired
  private TrainManagerService trainManagerService;

  @PostMapping("/addTrainForGym/{idGym}")
  TrainDTO addTrainForGym(@RequestBody TrainDTO train, @PathVariable String idGym) {
    return trainManagerService.addTrainForGym(train, idGym);
  }

  @PostMapping("/addTrainForSport/{idTrain}/{idSport}")
  void addTrainForSport(@PathVariable String idTrain, @PathVariable String idSport) {
    trainManagerService.addTrainForSport(idTrain, idSport);
  }

  @PutMapping("/editTrain/{id}")
  TrainDTO editTrain(@RequestBody TrainDTO train, @PathVariable String id) {
    return trainManagerService.editTrain(train, id);
  }

  @DeleteMapping("/deleteTrain/{id}")
  void deleteTrain(@PathVariable String id) {
    trainManagerService.deleteTrain(id);
  }

  @GetMapping("/findTrainById/{id}")
  TrainDTO findTrainById(@PathVariable String id) {
    return trainManagerService.findTrainById(id);
  }

  @GetMapping("/findAllTrains")
  List<TrainDTO> findAllTrains() {
    return trainManagerService.findAllTrains();
  }

  @GetMapping("/findTrainsForSport/{idSport}")
  List<TrainDTO> findTrainsForSport(@PathVariable String idSport) {
    return trainManagerService.findTrainsForSport(idSport);
  }

  @GetMapping("/findTrainsForGym/{idGym}")
  List<TrainDTO> findTrainsForGym(@PathVariable String idGym) {
    return trainManagerService.findTrainsForGym(idGym);
  }
}
