package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.GymDTO;
import project.gymBE.entity.Gym;
import project.gymBE.manager.GymManagerService;
import project.gymBE.repository.GymRepository;
import project.gymBE.service.GymService;

@Transactional
@Service
public class GymManagerServiceImpl implements GymManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();
  @Autowired
  private GymService gymService;
  @Autowired
  private GymRepository gymRepository;

  @Override
  public GymDTO addGym(GymDTO gymDTO) {
    Gym gym = modelMapper.map(gymDTO, Gym.class);
    return modelMapper.map(gymService.addGym(gym), GymDTO.class);
  }

  @Override
  public GymDTO editGym(GymDTO gymDTO, String id) {
    Gym gym = modelMapper.map(gymDTO, Gym.class);
    Gym existsGym = gymRepository.findById(id).orElse(null);
    return modelMapper.map(gymService.editGym(gym, existsGym), GymDTO.class);
  }

  @Override
  public void deleteGym(String id) {
    Gym existsGym = gymRepository.findById(id).orElse(null);
    gymRepository.delete(existsGym);
  }

  @Override
  public GymDTO findGymById(String id) {
    return modelMapper.map(gymRepository.findById(id).orElse(null), GymDTO.class);
  }

  @Override
  public List<GymDTO> findAllGyms() {
    List<Gym> gyms = gymRepository.findAll();
    return gyms.stream().map(gym -> modelMapper.map(gym, GymDTO.class))
        .collect(Collectors.toList());
  }
}
