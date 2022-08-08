package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.CreditCard;
import com.applaudostudios.ordermanagementapi.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentByCreditCard implements CreditCardService {

  private CreditCardRepository creditCardRepository;

  @Autowired
  public PaymentByCreditCard(CreditCardRepository creditCardRepository) {
    this.creditCardRepository = creditCardRepository;
  }

  @Override
  public CreditCard addPayment(CreditCard creditCard) {
    return creditCardRepository.save(creditCard);
  }

  @Override
  public CreditCard updatePayment(CreditCard creditCard) {
    Optional<CreditCard> creditCardUpdate = this.creditCardRepository.findById(creditCard.getId());
    if (creditCardUpdate.isPresent()) {
      creditCardUpdate.get().setNumber(creditCard.getNumber());
      creditCardUpdate.get().setCvv(creditCard.getCvv());
      creditCardUpdate.get().setExpDate(creditCard.getExpDate());
      creditCardRepository.save(creditCardUpdate.get());
      return creditCardUpdate.get();
    } else {
      throw new ResourceNotFoundException("Record not found with id : " + creditCard.getId());
    }
  }

  @Override
  public List<CreditCard> getAllPayments() {
    return this.creditCardRepository.findAll();
  }

  @Override
  public void deletePayment(long id) {
    this.creditCardRepository.deleteById(id);
  }
}
