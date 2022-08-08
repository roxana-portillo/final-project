package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.CreditCard;
import com.applaudostudios.ordermanagementapi.service.CreditCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CreditCardController.class)
@DisplayName("CreditCard Controller Tests")
class CreditCardControllerTest {

  @Autowired private MockMvc mockMvc;

  private CreditCard creditCard;

  @MockBean CreditCardService creditCardService;

  @BeforeEach
  void setUp() {
    creditCard = new CreditCard();
    creditCard.setNumber("4916613156275468");
    creditCard.setCvv("456");
    creditCard.setId(1L);
  }

  @Test
  @DisplayName("Find All CreditCard")
  void whenFindAll_thenReturnCreditCardList() throws Exception {
    List<CreditCard> allCreditCard = Arrays.asList(creditCard);

    when(creditCardService.getAllPayments()).thenReturn(allCreditCard);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/payments/all-cards")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
        .andExpect(status().isOk());

    verify(creditCardService).getAllPayments();
  }

  @Test
  @DisplayName("Save CreditCard")
  void saveCreditCard_WhenSuccessful() throws Exception {
    when(creditCardService.addPayment(any(CreditCard.class))).thenReturn(creditCard);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/v1/payments/add-card")
                .content(new ObjectMapper().writeValueAsString(creditCard))
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(creditCard.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(creditCard.getNumber()))
        .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Update CreditCard")
  void save_UpdateCreditCard_WhenSuccessful() throws Exception {
    creditCard.setCvv("476");
    when(creditCardService.updatePayment(any(CreditCard.class))).thenReturn(creditCard);
    mockMvc
        .perform(
            put("/v1/payments/update-card/1")
                .content(new ObjectMapper().writeValueAsString(creditCard))
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(creditCard.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.cvv").value(creditCard.getCvv()))
        .andExpect(status().isAccepted());
  }

  @Test
  @DisplayName("Delete")
  void delete_RemoveCreditCard_WhenSuccessful() throws Exception {
    doNothing().when(creditCardService).deletePayment(anyLong());

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/v1/payments/remove-card/1"))
        .andExpect(status().isOk());
    verify(creditCardService).deletePayment(anyLong());
  }
}
