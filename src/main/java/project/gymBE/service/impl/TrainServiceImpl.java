package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Train;
import project.gymBE.repository.TrainRepository;
import project.gymBE.service.TrainService;
@Service
public class TrainServiceImpl implements TrainService {

  @Autowired
  private TrainRepository trainRepository;

  @Override
  public Train addTrainForGym(Train train, Gym gym) {
    gym.getTrains().add(train);
    return trainRepository.save(train);
  }

  @Override
  public Train editTrain(Train train, Train existsTrain) {
    existsTrain.setName(train.getName());
    return trainRepository.save(existsTrain);
  }
}
