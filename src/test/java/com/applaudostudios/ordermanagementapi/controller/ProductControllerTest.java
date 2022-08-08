package com.applaudostudios.ordermanagementapi.controller;

import static com.applaudostudios.ordermanagementapi.util.Mapper.mapList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.applaudostudios.ordermanagementapi.dto.ProductDto;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import com.applaudostudios.ordermanagementapi.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ProductController.class)
@DisplayName("Product Controller Tests")
class ProductControllerTest {

  @Autowired private MockMvc mockMvc;
  private ProductDto product;

  @MockBean private ProductServiceImpl productService;
  @MockBean private ModelMapper modelMapper;

  @BeforeEach
  void setUp() {
    modelMapper = new ModelMapper();
    product = new ProductDto();
    product.setId(1L);
    product.setName("Desk Lamp");
    product.setPrice(BigDecimal.valueOf(25L));
  }

  @Test
  @DisplayName("Get Product List")
  void whenFindAll_thenReturnProductList() throws Exception {
    List<ProductDto> allProducts = Arrays.asList(product);

    when(mapList(productService.getAllProducts(), ProductDto.class, modelMapper))
        .thenReturn(allProducts);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/products/all-products")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
        .andExpect(status().isOk());

    verify(productService).getAllProducts();
  }

  @Test
  @DisplayName("Find Product By Id")
  void whenFindById_thenReturnProduct() throws Exception {
    when(productService.getProductById(anyLong())).thenReturn(any());

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/products/find-product/1")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

    verify(productService).getProductById(anyLong());
  }
}
