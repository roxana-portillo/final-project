package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
  List<Product> getAllProducts();

  Product getProductById(long id);

}
