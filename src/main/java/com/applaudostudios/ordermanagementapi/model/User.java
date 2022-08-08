package com.applaudostudios.ordermanagementapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

  private String phoneNumber;

  @Column(nullable = false, unique = true, updatable = false)
  @Email(message = "Invalid email")
  @NotEmpty(message = "Please enter email")
  private String email;

  @NotEmpty(message = "Please enter password")
  private String password;

  @OneToMany(
      fetch = FetchType.LAZY,
      mappedBy = "user",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Address> addressList;

  @OneToMany(
      fetch = FetchType.LAZY,
      mappedBy = "user",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<CreditCard> paymentMethods;

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }

  public void setPaymentMethods(List<CreditCard> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }
}
