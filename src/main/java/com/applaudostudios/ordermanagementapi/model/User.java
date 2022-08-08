package com.applaudostudios.ordermanagementapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(
    name = "user",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Size(max = 50, message = "Invalid first name")
  @NotEmpty(message = "Please enter first name")
  private String firstName;

  @Size(max = 50, message = "Invalid last name")
  @NotEmpty(message = "Please enter last name")
  private String lastName;

  @Pattern(regexp = "^\\(?(\\+503)\\)?([ ]?)([0-9]{4})\\2([0-9]{4})", message = "Incorrect format")
  private String phoneNumber;

  @Email(message = "Invalid email")
  @NotEmpty(message = "Please enter email")
  private String email;

  @NotEmpty(message = "Please enter password")
  private String password;

  @OneToMany(
          fetch = FetchType.LAZY,
          mappedBy = "user",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Address> addressList;

  @OneToMany(
          fetch = FetchType.LAZY,
          mappedBy = "user",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<CreditCard> paymentMethods;

}
