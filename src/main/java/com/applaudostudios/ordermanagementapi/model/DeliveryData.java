package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @NotEmpty(message = "Please enter order id")
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String trackNumber;

    @Enumerated
    @Column(name = "status_id")
    private Status status;

}
