package com.applaudostudios.ordermanagementapi.controller;

import com.applaudostudios.ordermanagementapi.model.Address;
import com.applaudostudios.ordermanagementapi.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
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
@WebMvcTest(AddressController.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AddressControllerTest {

  @Autowired private MockMvc mockMvc;

  private Address address;

  @MockBean AddressService addressService;

  @BeforeEach
  void setUp() {
    address = new Address();
    address.setAddress1("Col. Los Pinos Calle C #24");
    address.setId(1L);
  }

  @Test
  void whenFindAll_thenReturnAddressList() throws Exception {
    List<Address> allAddress = Arrays.asList(address);

    when(addressService.getAllAddress()).thenReturn(allAddress);

    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/v1/address/all-address")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
        .andExpect(status().isOk());

    verify(addressService).getAllAddress();
  }

  @Test
  void saveAddress_WhenSuccessful() throws Exception {
    when(addressService.addAddress(any(Address.class))).thenReturn(address);

    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/v1/address/add-address")
                .content(new ObjectMapper().writeValueAsString(address))
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(address.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.address1").value(address.getAddress1()))
        .andExpect(status().isOk());
  }

  @Test
  void save_UpdateAddress_WhenSuccessful() throws Exception {
    address.setAddress1("Col. Los Pinos Calle C #24");
    when(addressService.updateAddress(any(Address.class))).thenReturn(address);
    mockMvc
        .perform(
            put("/v1/address/update-address/1")
                .content(new ObjectMapper().writeValueAsString(address))
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(address.getId()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.address1").value(address.getAddress1()))
        .andExpect(status().isAccepted());
  }

  @Test
  void delete_RemoveAddress_WhenSuccessful() throws Exception {
    doNothing().when(addressService).deleteAddress(anyLong());

    mockMvc
        .perform(MockMvcRequestBuilders.delete("/v1/address/remove-item/10"))
        .andExpect(status().isOk());
    verify(addressService).deleteAddress(anyLong());
  }
}
