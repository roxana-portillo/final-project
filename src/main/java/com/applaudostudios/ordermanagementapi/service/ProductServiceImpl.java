package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.Product;
import com.applaudostudios.ordermanagementapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> getAllProducts() {
    return this.productRepository.findAll();
  }

  @Override
  public Product getProductById(long id) {
    Optional<Product> product = this.productRepository.findById(id);
    if (product.isPresent()) {
      return product.get();
    } else {
      throw new ResourceNotFoundException("Record not found with email : " + id);
    }
  }
}
