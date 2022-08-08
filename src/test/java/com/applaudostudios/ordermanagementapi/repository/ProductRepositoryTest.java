package com.applaudostudios.ordermanagementapi.repository;

import com.applaudostudios.ordermanagementapi.model.Category;
import com.applaudostudios.ordermanagementapi.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@DisplayName("Product Repository Tests")
class ProductRepositoryTest {

  @Autowired private ProductRepository productRepository;

  private Product product;

  @BeforeEach
  void setUp() {
    product = new Product();
    product.setCategory(Category.HOME);
    product.setId(1L);
    product.setName("Desk Lamp");
    product.setPrice(BigDecimal.valueOf(25L));
    product.setStock(59);
  }

  @Test
  @Rollback(false)
  @Order(1)
  @DisplayName("Save creates Product when successful")
  void save_CreateProduct_WhenSuccessful() {
    Product savedProduct = this.productRepository.save(product);
    assertThat(savedProduct).isNotNull();
    assertThat(savedProduct.getId()).isEqualTo(product.getId());
  }

  @Test
  @Order(2)
  @DisplayName("Find by id returns product when successful")
  void givenProductObject_whenFindById_thenReturnProduct() {
    Optional<Product> foundProduct = this.productRepository.findById(product.getId());
    assertThat(foundProduct).isNotNull();
    assertThat(foundProduct.get().getId()).isEqualTo(product.getId());
  }

  @Test
  @Order(3)
  @DisplayName("Find All returns product list when successful")
  void whenFindAll_thenReturnProductList() {
    List<Product> products = this.productRepository.findAll();
    assertThat(products).size().isZero();
  }
}
