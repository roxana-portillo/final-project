package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("CreditCard Repository Tests")
class CreditCardRepositoryTest {

  @Autowired private CreditCardRepository creditCardRepository;

  private CreditCard creditCard;

  @BeforeEach
  void setUp() {
    creditCard = new CreditCard();
    creditCard.setNumber("4916613156275468");
    creditCard.setCvv("456");
    creditCard.setId(1L);
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates CreditCard when successful")
  void save_CreateCreditCard_WhenSuccessful() {
    CreditCard savedCreditCard = this.creditCardRepository.save(creditCard);
    assertThat(savedCreditCard).isNotNull();
    assertThat(savedCreditCard.getId()).isEqualTo(creditCard.getId());
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns CreditCard when successful")
  void givenCreditCardObject_whenFindById_thenReturnCreditCard() {
    Optional<CreditCard> foundCreditCard = this.creditCardRepository.findById(creditCard.getId());
    assertThat(foundCreditCard).isNotNull();
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns CreditCard list when successful")
  void whenFindAll_thenReturnCreditCardList() {
    List<CreditCard> creditCards = this.creditCardRepository.findAll();
    assertThat(creditCards).size().isPositive();
  }
}
