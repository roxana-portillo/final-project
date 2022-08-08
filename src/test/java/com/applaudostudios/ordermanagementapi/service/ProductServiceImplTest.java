package com.applaudostudios.ordermanagementapi.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import com.applaudostudios.ordermanagementapi.model.Category;
import com.applaudostudios.ordermanagementapi.model.Product;
import com.applaudostudios.ordermanagementapi.repository.ProductRepository;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Product Service Implementation Tests")
class ProductServiceImplTest {
  @Mock private ProductRepository productRepository;

  @Autowired @InjectMocks private ProductServiceImpl productService;
  Product product;
  List<Product> productList;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    productList = new ArrayList<>();
    product = new Product();
    product.setCategory(Category.GENERAL);
    product.setDescription("The characteristics of someone or something");
    product.setId(123L);
    product.setName("Name");
    BigDecimal valueOfResult = BigDecimal.valueOf(42L);
    product.setPrice(valueOfResult);
    product.setStock(1);
    productList.add(product);
  }

  @Test
  @DisplayName("Get Product List")
  void shouldReturnListOfAllProducts() {
    productRepository.save(product);
    when(productRepository.findAll()).thenReturn(productList);
    List<Product> productList1 = productService.getAllProducts();
    assertThat(productList1).isEqualTo(productList);
    verify(productRepository, times(1)).save(product);
    verify(productRepository, times(1)).findAll();
  }

  @Test
  @DisplayName("Get Product By Id")
  void givenId_ThenShouldReturnProductOfThatId() {
    when(productRepository.findById(123L)).thenReturn(Optional.ofNullable(product));
    assertThat(productService.getProductById(product.getId())).isNotNull();
    verify(productRepository, times(1)).findById(anyLong());
  }
}
