package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.TrainDTO;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Sport;
import project.gymBE.entity.Train;
import project.gymBE.manager.TrainManagerService;
import project.gymBE.repository.GymRepository;
import project.gymBE.repository.SportRepository;
import project.gymBE.repository.TrainRepository;
import project.gymBE.service.TrainService;

@Transactional
@Service
public class TrainManagerServiceImpl implements TrainManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private TrainRepository trainRepository;
  @Autowired
  private TrainService trainService;
  @Autowired
  private SportRepository sportRepository;
  @Autowired
  private GymRepository gymRepository;

  @Override
  public TrainDTO addTrainForGym(TrainDTO trainDTO, String idGym) {
    Gym gym = gymRepository.findById(idGym).orElse(null);
    Train train = modelMapper.map(trainDTO, Train.class);
    return modelMapper.map(trainService.addTrainForGym(train, gym), TrainDTO.class);
  }

  @Override
  public void addTrainForSport(String idTrain, String idSport) {
    Sport sport = sportRepository.findById(idSport).orElse(null);
    Train train = trainRepository.findById(idTrain).orElse(null);
    sport.getTrains().add(train);
  }

  @Override
  public TrainDTO editTrain(TrainDTO trainDTO, String id) {
    Train train = modelMapper.map(trainDTO, Train.class);
    Train existsTrain = trainRepository.findById(id).orElse(null);
    return modelMapper.map(trainService.editTrain(train, existsTrain), TrainDTO.class);
  }

  @Override
  public void deleteTrain(String id) {
    Train existsTrain = trainRepository.findById(id).orElse(null);
    trainRepository.delete(existsTrain);
  }

  @Override
  public TrainDTO findTrainById(String id) {
    return modelMapper.map(sportRepository.findById(id).orElse(null), TrainDTO.class);
  }

  @Override
  public List<TrainDTO> findAllTrains() {
    List<Train> trains = trainRepository.findAll();
    return trains.stream().map(train -> modelMapper.map(train, TrainDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<TrainDTO> findTrainsForSport(String idSport) {
    Sport sport = sportRepository.findById(idSport).orElse(null);
    List<Train> trains = sport.getTrains();
    return trains.stream().map(train -> modelMapper.map(train, TrainDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<TrainDTO> findTrainsForGym(String idGym) {
    Gym gym = gymRepository.findById(idGym).orElse(null);
    List<Train> trains = gym.getTrains();
    return trains.stream().map(train -> modelMapper.map(train, TrainDTO.class))
        .collect(Collectors.toList());
  }
}
