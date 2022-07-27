package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "id_cart", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @PositiveOrZero(message = "Invalid amount")
    private double total;
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
