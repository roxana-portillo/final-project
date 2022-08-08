package com.applaudostudios.ordermanagementapi.model;

import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("User Validations Test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserTest {

  private User user;

  private Validator validator;

  @BeforeEach
  void setUp() {
    user = new User();
    user.setId(1);
    user.setFirstName("Roxana");
    user.setLastName("Portillo");
    user.setEmail("roxy@gmail.com");
    user.setPhoneNumber("+503 77889966");
    user.setPassword("password");

    try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
      validator = factory.getValidator();
    }
  }

  @Test
  void should_Return_Id() {
    Long id = user.getId();
    assertThat(id).isEqualTo(1L);
  }

  @Test
  void invalid_Email_Should_Fail_Validation() {
    user.setEmail("roxygmail.com");
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    assertThat(violations).isNotEmpty();
  }

  @Test
  void invalid_First_Name_Should_Fail_Validation() {
    user.setFirstName("");
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    assertThat(violations).isNotEmpty();
  }

  @Test
  void invalid_Last_Name_Should_Fail_Validation() {
    user.setLastName("");
    Set<ConstraintViolation<User>> violations = validator.validate(user);
    assertThat(violations).isNotEmpty();
  }
}
