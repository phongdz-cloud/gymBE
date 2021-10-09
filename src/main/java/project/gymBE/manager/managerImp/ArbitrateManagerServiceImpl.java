package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.ArbitrateDTO;
import project.gymBE.entity.Arbitrate;
import project.gymBE.entity.Gym;
import project.gymBE.entity.Sport;
import project.gymBE.manager.ArbitrateManagerService;
import project.gymBE.repository.ArbitrateRepository;
import project.gymBE.repository.GymRepository;
import project.gymBE.repository.SportRepository;
import project.gymBE.service.ArbitrateService;

@Transactional
@Service
public class ArbitrateManagerServiceImpl implements ArbitrateManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private ArbitrateService arbitrateService;

  @Autowired
  private SportRepository sportRepository;

  @Autowired
  private ArbitrateRepository arbitrateRepository;

  @Autowired

  private GymRepository gymRepository;


  @Override
  public void addArbitrateForSport(String idArbitrate, String idSport) {
    Sport sport = sportRepository.findById(idSport).orElse(null);
    Arbitrate arbitrate = arbitrateRepository.findById(idArbitrate).orElse(null);
    sport.getArbitrates().add(arbitrate);
  }

  @Override
  public ArbitrateDTO addArbitrateForGym(ArbitrateDTO arbitrateDTO, String idGym) {
    Gym gym = gymRepository.findById(idGym).orElse(null);
    Arbitrate arbitrate = modelMapper.map(arbitrateDTO, Arbitrate.class);
    return modelMapper.map(arbitrateService.addArbitrateForGym(arbitrate, gym),
        ArbitrateDTO.class);
  }

  @Override
  public ArbitrateDTO editArbitrate(ArbitrateDTO arbitrateDTO, String id) {
    Arbitrate existArbitrate = arbitrateRepository.findById(id).orElse(null);
    Arbitrate arbitrate = modelMapper.map(arbitrateDTO, Arbitrate.class);
    return modelMapper.map(arbitrateService.editArbitrate(arbitrate, existArbitrate),
        ArbitrateDTO.class);
  }

  @Override
  public void deleteArbitrate(String id) {
    Arbitrate existsArbitrate = arbitrateRepository.findById(id).orElse(null);
    arbitrateService.delete(existsArbitrate);
  }

  @Override
  public ArbitrateDTO findArbitrateById(String id) {
    return modelMapper.map(arbitrateRepository.findById(id).orElse(null), ArbitrateDTO.class);
  }

  @Override
  public List<ArbitrateDTO> findArbitratesForSport(String idSport) {
    Sport sport = sportRepository.findById(idSport).orElse(null);
    List<Arbitrate> arbitrates = sport.getArbitrates();
    return arbitrates.stream().map(arbitrate -> modelMapper.map(arbitrate, ArbitrateDTO.class))
        .collect(
            Collectors.toList());
  }

  @Override
  public List<ArbitrateDTO> findArbitratesForGym(String id) {
    Gym gym = gymRepository.findById(id).orElse(null);
    List<Arbitrate> arbitrates = gym.getArbitrates();
    return arbitrates.stream().map(arbitrate -> modelMapper.map(arbitrate, ArbitrateDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<ArbitrateDTO> findAllArbitrates() {
    List<Arbitrate> arbitrates = arbitrateRepository.findAll();
    return arbitrates.stream().map(arbitrate -> modelMapper.map(arbitrate, ArbitrateDTO.class))
        .collect(Collectors.toList());
  }
}
