package project.gymBE.manager;

import java.util.List;
import project.gymBE.dto.PaymentDTO;

public interface PaymentManagerService {

  PaymentDTO addPayment(PaymentDTO payment, String idSportsMan);

  PaymentDTO editPayment(PaymentDTO payment, String id);

  void deletePayment(String id);

  PaymentDTO findPaymentById(String id);

  List<PaymentDTO> findPaymentsForSportMan(String idSportsMan);

}
