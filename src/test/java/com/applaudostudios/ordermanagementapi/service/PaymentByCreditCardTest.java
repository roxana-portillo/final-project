package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.CreditCard;
import com.applaudostudios.ordermanagementapi.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class PaymentByCreditCardTest {

  @Mock private CreditCardRepository creditCardRepository;

  @InjectMocks private PaymentByCreditCard creditCardService;
  private CreditCard creditCard;
  List<CreditCard> creditCardList;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    creditCardList = new ArrayList<>();
    creditCard = new CreditCard();
    creditCard.setNumber("4916613156275468");
    creditCard.setCvv("456");
    creditCard.setId(1L);
    creditCardList.add(creditCard);
  }

  @Test
  @DisplayName("Save CreditCard")
  void saveCreditCard_ShouldReturnAddedCreditCard() {
    when(creditCardRepository.save(any(CreditCard.class))).thenReturn(creditCard);
    creditCardService.addPayment(creditCard);
    verify(creditCardRepository, times(1)).save(any(CreditCard.class));
  }

  @Test
  @DisplayName("Get CreditCard List")
  void allCreditCard_ShouldReturnListOfAllCreditCard() {
    creditCardRepository.save(creditCard);
    when(creditCardRepository.findAll()).thenReturn(creditCardList);
    List<CreditCard> creditCardList1 = creditCardService.getAllPayments();
    assertThat(creditCardList1).isEqualTo(creditCardList);
    verify(creditCardRepository, times(1)).save(creditCard);
    verify(creditCardRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Update CreditCard")
  void givenCreditCardObject_whenUpdateCreditCard_thenReturnUpdatedCreditCard() {
    when(creditCardRepository.save(creditCard)).thenReturn(any(CreditCard.class));
    creditCard.setCvv("455");
    assertThatExceptionOfType(ResourceNotFoundException.class)
        .isThrownBy(() -> creditCardService.updatePayment(creditCard));
  }

  @Test
  @DisplayName("Delete CreditCard")
  void givenId_ThenShouldDeleteTheCreditCardOfThatId() {
    doNothing().when(creditCardRepository).deleteById(1L);
    creditCardService.deletePayment(1L);
    verify(creditCardRepository, times(1)).deleteById(1L);
  }
}
