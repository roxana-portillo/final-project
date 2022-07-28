package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @PositiveOrZero(message = "Invalid amount")
    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
