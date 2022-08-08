package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.dto.ProductDto;
import com.applaudostudios.ordermanagementapi.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.applaudostudios.ordermanagementapi.util.Mapper.mapList;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

  private ProductService productService;

  private ModelMapper modelMapper;

  @Autowired
  public ProductController(ProductService productService, ModelMapper modelMapper) {
    this.productService = productService;
    this.modelMapper = modelMapper;
  }

  @GetMapping("/find-product/{productId}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable long productId) {
    return ResponseEntity.ok()
        .body(modelMapper.map(productService.getProductById(productId), ProductDto.class));
  }

  @GetMapping("/all-products")
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    return ResponseEntity.ok()
        .body(mapList(productService.getAllProducts(), ProductDto.class, modelMapper));
  }
}
