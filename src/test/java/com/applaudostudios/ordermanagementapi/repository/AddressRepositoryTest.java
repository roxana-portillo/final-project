package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.Address;
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
@DisplayName("Address Repository Tests")
class AddressRepositoryTest {

  @Autowired private AddressRepository addressRepository;

  private Address address;

  @BeforeEach
  void setUp() {
    address = new Address();
    address.setAddress1("Col. Los Pinos Calle C #24");
    address.setId(1L);
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates address when successful")
  void save_CreateAddress_WhenSuccessful() {
    Address savedAddress = this.addressRepository.save(address);
    assertThat(savedAddress).isNotNull();
    assertThat(savedAddress.getId()).isEqualTo(address.getId());
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns address when successful")
  void givenAddressObject_whenFindById_thenReturnAddress() {
    Optional<Address> foundAddress = this.addressRepository.findById(address.getId());
    assertThat(foundAddress).isNotNull();
    assertThat(foundAddress.get().getId()).isEqualTo(address.getId());
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns address list when successful")
  void whenFindAll_thenReturnAddressList() {
    List<Address> address = this.addressRepository.findAll();
    assertThat(address).size().isZero();
  }
}
