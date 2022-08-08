package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.Address;
import com.applaudostudios.ordermanagementapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

  private AddressRepository addressRepository;

  @Autowired
  public AddressServiceImpl(AddressRepository addressRepository) {
    this.addressRepository = addressRepository;
  }

  @Override
  public Address addAddress(Address address) {
    return addressRepository.save(address);
  }

  @Override
  public Address updateAddress(Address address) {
    Optional<Address> addressUpdate = this.addressRepository.findById(address.getId());
    if (addressUpdate.isPresent()) {
      addressUpdate.get().setAddress1(address.getAddress1());
      addressUpdate.get().setAddress2(address.getAddress2());
      addressUpdate.get().setCity(address.getCity());
      addressRepository.save(addressUpdate.get());
      return addressUpdate.get();
    } else {
      throw new ResourceNotFoundException("Record not found with id : " + address.getId());
    }
  }

  @Override
  public List<Address> getAllAddress() {
    return this.addressRepository.findAll();
  }

  @Override
  public void deleteAddress(long id) {
    this.addressRepository.deleteById(id);
  }
}
