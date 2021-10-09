package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.TrainDTO;

public interface TrainManagerService {

  TrainDTO addTrainForGym(TrainDTO trainDTO, String idGym);

  void addTrainForSport(String idTrain, String idSport);

  TrainDTO editTrain(TrainDTO trainDTO, String id);

  void deleteTrain(String id);

  TrainDTO findTrainById(String id);

  List<TrainDTO> findAllTrains();

  List<TrainDTO> findTrainsForSport(String idSport);

  List<TrainDTO> findTrainsForGym(String idGym);

}
