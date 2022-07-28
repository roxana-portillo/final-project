package com.applaudostudios.ordermanagementapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotEmpty(message = "Please enter a state name")
    @Size(max = 25)
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId")
    private Country country;
}