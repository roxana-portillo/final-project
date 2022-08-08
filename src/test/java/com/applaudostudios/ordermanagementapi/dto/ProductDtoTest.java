package com.applaudostudios.ordermanagementapi.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ProductDto Tests")
class ProductDtoTest {
  /**
   * Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ProductDto}
   *   <li>{@link ProductDto#setId(long)}
   *   <li>{@link ProductDto#setName(String)}
   *   <li>{@link ProductDto#setPrice(BigDecimal)}
   *   <li>{@link ProductDto#getId()}
   *   <li>{@link ProductDto#getName()}
   *   <li>{@link ProductDto#getPrice()}
   * </ul>
   */
  @Test
  @DisplayName("Should make productDto")
  void shouldReturnProductDto() {
    ProductDto actualProductDto = new ProductDto();

    actualProductDto.setId(123L);
    actualProductDto.setName("Name");
    BigDecimal valueOfResult = BigDecimal.valueOf(42L);
    actualProductDto.setPrice(valueOfResult);

    assertEquals(123L, actualProductDto.getId());
    assertEquals("Name", actualProductDto.getName());
    assertSame(valueOfResult, actualProductDto.getPrice());
  }
}
