package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.PaymentDetails;
import com.applaudostudios.ordermanagementapi.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("PaymentDetails Repository Tests")
class PaymentDetailsRepositoryTest {

  @Autowired private PaymentDetailsRepository paymentDetailsRepository;

  private PaymentDetails paymentDetails;

  @BeforeEach
  void setUp() {
    paymentDetails = new PaymentDetails();
    paymentDetails.setId(1L);
    paymentDetails.setAmount(BigDecimal.valueOf(25L));
    paymentDetails.setStatus(Status.PROCESSING);
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates paymentDetails when successful")
  void save_CreatePaymentDetails_WhenSuccessful() {
    PaymentDetails savedPaymentDetails = this.paymentDetailsRepository.save(paymentDetails);
    assertThat(savedPaymentDetails).isNotNull();
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns paymentDetails when successful")
  void givenPaymentDetailsObject_whenFindById_thenReturnPaymentDetails() {
    Optional<PaymentDetails> foundPaymentDetails =
        this.paymentDetailsRepository.findById(paymentDetails.getId());
    assertThat(foundPaymentDetails).isNotNull();
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns paymentDetails list when successful")
  void whenFindAll_thenReturnPaymentDetailsList() {
    List<PaymentDetails> paymentDetailsList = this.paymentDetailsRepository.findAll();
    assertThat(paymentDetailsList).size().isPositive();
  }
}
