package com.applaudostudios.ordermanagementapi.model;

import lombok.*;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

  @Id
  @Column(updatable = false, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "Please enter number")
  @CreditCardNumber(message = "Invalid card number")
  private String number;
  @Size(max = 3, message = "Invalid code")
  @NotEmpty(message = "Please enter cvv code")
  private String cvv;
  private double balance;
  @Size(max = 16, message = "Invalid number")
  @NotEmpty(message = "Please enter number")
  @Future(message = "Invalid date")
  private Date expDate;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public void setBalance(double balance) {
    this.balance -= balance;
  }
}
