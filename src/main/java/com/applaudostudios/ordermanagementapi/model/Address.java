package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @Column(name = "id_address", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String country;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address )) return false;
        return Long.valueOf(id) != null && Long.valueOf(id).equals(((Address) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
