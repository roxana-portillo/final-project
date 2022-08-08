package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.Address;
import com.applaudostudios.ordermanagementapi.repository.AddressRepository;
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

class AddressServiceImplTest {

  @Mock private AddressRepository addressRepository;

  @InjectMocks private AddressServiceImpl addressService;
  private Address address;
  List<Address> addressList;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    addressList = new ArrayList<>();
    address = new Address();
    address.setAddress1("Col. Los Pinos Calle C #24");
    address.setId(1L);
    addressList.add(address);
  }

  @Test
  @DisplayName("Save Address")
  void saveAddress_ShouldReturnAddedAddress() {
    when(addressRepository.save(any(Address.class))).thenReturn(address);
    addressService.addAddress(address);
    verify(addressRepository, times(1)).save(any(Address.class));
  }

  @Test
  @DisplayName("Get Address List")
  void allAddress_ShouldReturnListOfAllAddress() {
    addressRepository.save(address);
    when(addressRepository.findAll()).thenReturn(addressList);
    List<Address> addressList1 = addressService.getAllAddress();
    assertThat(addressList1).isEqualTo(addressList);
    verify(addressRepository, times(1)).save(address);
    verify(addressRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Update Address")
  void givenAddressObject_whenUpdateAddress_thenReturnUpdatedAddress() {
    when(addressRepository.save(address)).thenReturn(any(Address.class));
    address.setAddress1("Col. Los Pinos Calle C #24");
    assertThatExceptionOfType(ResourceNotFoundException.class)
        .isThrownBy(() -> addressService.updateAddress(address));
  }

  @Test
  @DisplayName("Delete Address")
  void givenId_ThenShouldDeleteTheAddressOfThatId() {
    doNothing().when(addressRepository).deleteById(1L);
    addressService.deleteAddress(1L);
    verify(addressRepository, times(1)).deleteById(1L);
  }
}
