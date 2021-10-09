package project.gymBE.service;

import java.util.Optional;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Train;
import project.gymBE.entity.User;

public interface TrainService {

  Train addTrainForGym(Train train, Gym gym);

  Train editTrain(Train train, Train existsTrain);
}
