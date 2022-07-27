package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_orderitem", updatable = false, nullable = false)
  private Long id;
  @NotEmpty(message = "Please enter password")
  @Size(min = 1)
  private int quantity;
  @NotEmpty(message = "Please enter password")
  private Long item;
  @ManyToOne(fetch = FetchType.LAZY)
  private Order order;
}
