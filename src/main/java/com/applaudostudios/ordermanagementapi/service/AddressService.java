package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    Address addAddress(Address address);
    Address updateAddress(Address address);
    List<Address> getAllAddress();
    void deleteAddress(long id);
}
