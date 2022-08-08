package com.applaudostudios.ordermanagementapi.service;

import com.applaudostudios.ordermanagementapi.exception.ResourceNotFoundException;
import com.applaudostudios.ordermanagementapi.model.PaymentDetails;
import com.applaudostudios.ordermanagementapi.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

  private PaymentDetailsRepository paymentDetailsRepository;

  @Autowired
  public PaymentDetailsServiceImpl(PaymentDetailsRepository paymentDetailsRepository) {
    this.paymentDetailsRepository = paymentDetailsRepository;
  }

  @Override
  public PaymentDetails createPaymentDetails(PaymentDetails paymentDetails) {
    return paymentDetailsRepository.save(paymentDetails);
  }

  @Override
  public PaymentDetails getPaymentDetailsById(long id) {
    Optional<PaymentDetails> paymentDetails = this.paymentDetailsRepository.findById(id);
    if (paymentDetails.isPresent()) {
      return paymentDetails.get();
    } else {
      throw new ResourceNotFoundException("Record not found with email : " + id);
    }
  }
}
