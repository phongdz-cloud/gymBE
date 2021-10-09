package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.SportDTO;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Sport;
import project.gymBE.entity.SportsMan;
import project.gymBE.manager.SportManagerService;
import project.gymBE.repository.GymRepository;
import project.gymBE.repository.SportRepository;
import project.gymBE.repository.SportsManRepository;
import project.gymBE.service.SportService;

@Transactional
@Service
public class SportManagerServiceImpl implements SportManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private SportRepository sportRepository;

  @Autowired
  private SportService sportService;

  @Autowired
  private SportsManRepository sportsManRepository;

  @Autowired
  private GymRepository gymRepository;

  @Override
  public SportDTO addSportForGym(SportDTO sportDTO, String idGym) {
    Sport sport = modelMapper.map(sportDTO, Sport.class);
    Gym gym = gymRepository.findById(idGym).orElse(null);
    sport.setIdGym(gym.getId());
    return modelMapper.map(sportService.addSport(sport, gym), SportDTO.class);
  }

  @Override
  public void addSportForSportsMan(String idSport, String idSportsMan) {
    SportsMan sportsMan = sportsManRepository.findById(idSportsMan).orElse(null);
    Sport existsSport = sportRepository.findById(idSport).orElse(null);
    sportsMan.getSports().add(existsSport);
    sportsManRepository.save(sportsMan);
  }

  @Override
  public SportDTO editSport(SportDTO sportDTO, String id) {
    Sport sport = modelMapper.map(sportDTO, Sport.class);
    Sport existsSport = sportRepository.findById(id).orElse(null);
    return modelMapper.map(sportService.editSport(sport, existsSport), SportDTO.class);
  }

  @Override
  public void deleteSport(String id) {
    Sport existsSport = sportRepository.findById(id).orElse(null);
    sportRepository.delete(existsSport);
  }

  @Override
  public SportDTO findSportById(String id) {
    return modelMapper.map(sportRepository.findById(id).orElse(null), SportDTO.class);
  }

  @Override
  public List<SportDTO> findSportsForSportsMan(String idSportsMan) {
    SportsMan sportsMan = sportsManRepository.findById(idSportsMan).orElse(null);
    List<Sport> sports = sportsMan.getSports();
    return sports.stream().map(sport -> modelMapper.map(sport, SportDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<SportDTO> findSportsForGym(String idGym) {
    Gym gym = gymRepository.findById(idGym).orElse(null);
    List<Sport> sports = gym.getSports();
    return sports.stream().map(sport -> modelMapper.map(sport, SportDTO.class))
        .collect(Collectors.toList());
  }
}
