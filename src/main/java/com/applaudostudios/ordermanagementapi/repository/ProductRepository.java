package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
