package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

  @Enumerated
  @Column(name = "status_id")
private Status status;
@FutureOrPresent
private LocalDateTime date;

  @OneToMany(
          fetch = FetchType.LAZY,
          mappedBy = "order",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  @Size(min = 1)
  private List<OrderItem> orderItems;

  @PositiveOrZero
  private BigDecimal total;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
}
