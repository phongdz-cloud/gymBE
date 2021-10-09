package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.SportsManDTO;
import project.gymBE.entity.SportsMan;
import project.gymBE.manager.SportsManManagerService;
import project.gymBE.repository.SportsManRepository;
import project.gymBE.service.SportsManService;

@Transactional
@Service
public class SportsManManagerServiceImpl implements SportsManManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private SportsManRepository sportsManRepository;
  @Autowired
  private SportsManService sportsManService;

  @Override
  public SportsManDTO addSportsMan(SportsManDTO sportsManDTO) {
    SportsMan sportsMan = modelMapper.map(sportsManDTO, SportsMan.class);
    return modelMapper.map(sportsManService.addSportsMan(sportsMan), SportsManDTO.class);
  }

  @Override
  public SportsManDTO editSportsMan(SportsManDTO sportsManDTO, String id) {
    SportsMan sportsMan = modelMapper.map(sportsManDTO, SportsMan.class);
    SportsMan existsSportsMan = sportsManRepository.findById(id).orElse(null);
    return modelMapper.map(sportsManService.editSportsMan(sportsMan, existsSportsMan),
        SportsManDTO.class);
  }

  @Override
  public void deleteSportsMan(String id) {
    SportsMan existsSportsMan = sportsManRepository.findById(id).orElse(null);
    sportsManRepository.delete(existsSportsMan);
  }

  @Override
  public SportsManDTO findSportsManById(String id) {
    return modelMapper.map(sportsManRepository.findById(id).orElse(null), SportsManDTO.class);
  }

  @Override
  public List<SportsManDTO> findAllSportsMans() {
    List<SportsMan> sportsMans = sportsManRepository.findAll();
    return sportsMans.stream().map(sportsMan -> modelMapper.map(sportsMan, SportsManDTO.class))
        .collect(
            Collectors.toList());
  }
}
