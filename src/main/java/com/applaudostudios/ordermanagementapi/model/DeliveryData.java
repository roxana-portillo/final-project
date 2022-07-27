package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deliverydata", updatable = false, nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @NotEmpty(message = "Please enter order id")
    private Long order;

    private Status status;

    private String trackNumber;

}
