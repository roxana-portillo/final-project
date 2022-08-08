package com.applaudostudios.ordermanagementapi.service;


import com.applaudostudios.ordermanagementapi.model.PaymentDetails;

public interface PaymentDetailsService {
    PaymentDetails createPaymentDetails(PaymentDetails delivery);

    PaymentDetails getPaymentDetailsById(long id);
}
