package com.applaudostudios.ordermanagementapi.dto;

import lombok.RequiredArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@RequiredArgsConstructor
public class ProductDto implements Serializable {
  private long id;

  @Size(max = 50, message = "Invalid name")
  @NotEmpty(message = "Please enter name")
  private String name;

  @PositiveOrZero(message = "Invalid amount")
  private BigDecimal price;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}
