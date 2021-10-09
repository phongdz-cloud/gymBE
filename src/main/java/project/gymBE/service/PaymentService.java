package project.gymBE.service;

import project.gymBE.entity.Payment;
import project.gymBE.entity.SportsMan;

public interface PaymentService {

  Payment addPayment(Payment payment, SportsMan sportsMan);

  Payment editPayment(Payment payment, Payment existPayment);
}
