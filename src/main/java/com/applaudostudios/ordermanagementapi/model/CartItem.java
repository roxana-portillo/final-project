package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @NotEmpty(message = "Please enter product id")
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Size(min = 1, message = "Invalid quantity")
    @NotEmpty(message = "Please enter a quantity")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
