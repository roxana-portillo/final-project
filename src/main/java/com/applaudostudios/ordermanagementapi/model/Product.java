package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Size(max = 50, message = "Invalid name")
  @NotEmpty(message = "Please enter name")
  private String name;
  @PositiveOrZero(message = "Invalid amount")
  private BigDecimal price;
  private int stock;
  @Enumerated
  @Column(name = "category_id")
  private Category category;
  private String description;

  public void updateStock(int quantity) {
    this.stock -= quantity;
  }

}
