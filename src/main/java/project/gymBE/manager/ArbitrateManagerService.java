package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.ArbitrateDTO;

public interface ArbitrateManagerService {

  void addArbitrateForSport(String idArbitrate, String idSport);

  ArbitrateDTO addArbitrateForGym(ArbitrateDTO arbitrateDTO, String idGym);

  ArbitrateDTO editArbitrate(ArbitrateDTO arbitrateDTO, String id);

  void deleteArbitrate(String id);

  ArbitrateDTO findArbitrateById(String id);

  List<ArbitrateDTO> findArbitratesForSport(String idSport);

  List<ArbitrateDTO> findArbitratesForGym(String id);

  List<ArbitrateDTO> findAllArbitrates();

}
