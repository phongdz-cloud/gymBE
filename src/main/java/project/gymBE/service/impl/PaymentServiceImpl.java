package project.gymBE.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gymBE.entity.Payment;
import project.gymBE.entity.SportsMan;
import project.gymBE.repository.PaymentRepository;
import project.gymBE.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  @Override
  public Payment addPayment(Payment payment, SportsMan sportsMan) {
    sportsMan.getPayments().add(payment);
    return paymentRepository.save(payment);
  }

  @Override
  public Payment editPayment(Payment payment, Payment existPayment) {
    existPayment.setCost(payment.getCost());
    existPayment.setDate(payment.getDate());
    existPayment.setDuration(payment.getDuration());
    return paymentRepository.save(existPayment);
  }
}
