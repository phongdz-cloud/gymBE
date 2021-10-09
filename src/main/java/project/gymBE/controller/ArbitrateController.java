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
import project.gymBE.dto.ArbitrateDTO;
import project.gymBE.manager.ArbitrateManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class ArbitrateController {

  @Autowired
  private ArbitrateManagerService arbitrateManagerService;

  @PostMapping("/addArbitrateForGym/{idGym}")
  ArbitrateDTO addArbitrate(@RequestBody ArbitrateDTO arbitrateDTO, @PathVariable String idGym) {
    return arbitrateManagerService.addArbitrateForGym(arbitrateDTO, idGym);
  }

  @PutMapping("/editArbitrate/{id}")
  ArbitrateDTO editArbitrate(@RequestBody ArbitrateDTO arbitrate, @PathVariable String id) {
    return arbitrateManagerService.editArbitrate(arbitrate, id);
  }

  @DeleteMapping("/deleteArbitrate/{id}")
  void deleteArbitrate(@PathVariable String id) {
    arbitrateManagerService.deleteArbitrate(id);
  }

  @GetMapping("/findAllArbitrates")
  List<ArbitrateDTO> findAllArbitrates() {
    return arbitrateManagerService.findAllArbitrates();
  }

  @GetMapping("/findArbitrateById/{id}")
  ArbitrateDTO findArbitrateById(@PathVariable String id) {
    return arbitrateManagerService.findArbitrateById(id);
  }

  @GetMapping("/findArbitratesForSport/{idSport}")
  List<ArbitrateDTO> findArbitratesForSport(@PathVariable String idSport) {
    return arbitrateManagerService.findArbitratesForSport(idSport);
  }

  @GetMapping("/findArbitratesForGym/{idGym}")
  List<ArbitrateDTO> findArbitratesForGym(@PathVariable String idGym) {
    return arbitrateManagerService.findArbitratesForGym(idGym);
  }
}
