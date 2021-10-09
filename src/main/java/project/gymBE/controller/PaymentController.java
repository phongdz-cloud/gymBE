package project.gymBE.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.gymBE.dto.PaymentDTO;
import project.gymBE.manager.PaymentManagerService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class PaymentController {

  @Autowired
  private PaymentManagerService paymentManagerService;

  @PostMapping("/addPayment/{idSportsMan}")
  PaymentDTO addPayment(@RequestBody PaymentDTO payment, @PathVariable String idSportsMan) {
    return paymentManagerService.addPayment(payment, idSportsMan);
  }

  @PutMapping("/editPayment/{id}")
  PaymentDTO editPayment(@RequestBody PaymentDTO payment, @PathVariable String id) {
    return paymentManagerService.editPayment(payment, id);
  }

  @DeleteMapping("/deletePayment/{id}")
  void deletePayment(@PathVariable String id) {
    paymentManagerService.deletePayment(id);
  }

  @GetMapping("/findPaymentById/{id}")
  PaymentDTO findPaymentById(@PathVariable String id) {
    return paymentManagerService.findPaymentById(id);
  }

  @GetMapping("{/findPaymentForSportsMan/{idSportsMan}")
  List<PaymentDTO> findPaymentsForSportsMan(@PathVariable String idSportsMan) {
    return paymentManagerService.findPaymentsForSportMan(idSportsMan);
  }
}
