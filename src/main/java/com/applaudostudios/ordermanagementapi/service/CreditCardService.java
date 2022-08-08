package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.CreditCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreditCardService {
  CreditCard addPayment(CreditCard creditCard);
  CreditCard updatePayment(CreditCard creditCard);
  List<CreditCard> getAllPayments();
  void deletePayment(long id);
}
