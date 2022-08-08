package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}