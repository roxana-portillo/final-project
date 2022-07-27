package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_order", updatable = false, nullable = false)
  private Long id;
private Status status;
@FutureOrPresent
private Date date;

  @OneToMany(
          mappedBy = "order",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @Size(min = 1)
  private List<OrderItem> orderItems = new ArrayList<>();

  private double total;
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;
}
