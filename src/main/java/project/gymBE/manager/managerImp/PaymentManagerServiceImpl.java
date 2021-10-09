package project.gymBE.manager.managerImp;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.gymBE.dto.PaymentDTO;
import project.gymBE.entity.Payment;
import project.gymBE.entity.SportsMan;
import project.gymBE.manager.PaymentManagerService;
import project.gymBE.repository.PaymentRepository;
import project.gymBE.repository.SportsManRepository;
import project.gymBE.service.PaymentService;

@Service
@Transactional
public class PaymentManagerServiceImpl implements PaymentManagerService {

  private static final ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private PaymentService paymentService;

  @Autowired
  private PaymentRepository paymentRepository;

  @Autowired
  private SportsManRepository sportsManRepository;


  @Override
  public PaymentDTO addPayment(PaymentDTO payment, String idSportsMan) {
    SportsMan sportsMan = sportsManRepository.findById(idSportsMan).orElse(null);
    Payment paymentEntity = modelMapper.map(payment, Payment.class);
    return modelMapper.map(paymentService.addPayment(paymentEntity, sportsMan), PaymentDTO.class);
  }

  @Override
  public PaymentDTO editPayment(PaymentDTO payment, String id) {
    Payment paymentEntity = modelMapper.map(payment, Payment.class);
    Payment existsPayment = paymentRepository.findById(id).orElse(null);
    return modelMapper.map(paymentService.editPayment(paymentEntity, existsPayment),
        PaymentDTO.class);
  }

  @Override
  public void deletePayment(String id) {
    Payment existsPayment = paymentRepository.findById(id).orElse(null);
    paymentRepository.delete(existsPayment);
  }

  @Override
  public PaymentDTO findPaymentById(String id) {
    return modelMapper.map(paymentRepository.findById(id).orElse(null), PaymentDTO.class);
  }

  @Override
  public List<PaymentDTO> findPaymentsForSportMan(String idSportsMan) {
    SportsMan sportsMan = sportsManRepository.findById(idSportsMan).orElse(null);
    List<Payment> payments = sportsMan.getPayments();
    return payments.stream().map(payment -> modelMapper.map(payment, PaymentDTO.class)).collect(
        Collectors.toList());
  }
}
