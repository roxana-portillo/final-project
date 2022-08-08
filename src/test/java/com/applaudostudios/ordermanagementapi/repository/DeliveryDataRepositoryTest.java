package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.DeliveryData;
import com.applaudostudios.ordermanagementapi.model.Status;
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
@DisplayName("DeliveryData Repository Tests")
class DeliveryDataRepositoryTest {

  @Autowired private DeliveryDataRepository deliveryDataRepository;

  private DeliveryData deliveryData;

  @BeforeEach
  void setUp() {
    deliveryData = new DeliveryData();
    deliveryData.setId(1L);
    deliveryData.setStatus(Status.PROCESSING);
    deliveryData.setTrackNumber("42222222222");
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates DeliveryData when successful")
  void save_CreateDeliveryData_WhenSuccessful() {
    DeliveryData savedDeliveryData = this.deliveryDataRepository.save(deliveryData);
    assertThat(savedDeliveryData).isNotNull();
    assertThat(savedDeliveryData.getId()).isEqualTo(deliveryData.getId());
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns DeliveryData when successful")
  void givenDeliveryDataObject_whenFindById_thenReturnDeliveryData() {
    Optional<DeliveryData> foundDeliveryData =
        this.deliveryDataRepository.findById(deliveryData.getId());
    assertThat(foundDeliveryData).isNotNull();
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns DeliveryData list when successful")
  void whenFindAll_thenReturnDeliveryDataList() {
    List<DeliveryData> deliveryDataList = this.deliveryDataRepository.findAll();
    assertThat(deliveryDataList).size().isPositive();
  }
}
