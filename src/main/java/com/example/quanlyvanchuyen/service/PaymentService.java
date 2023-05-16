package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.PaymentResponse;
import com.example.quanlyvanchuyen.DTO.Paymentdto;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> listPayment();
    PaymentResponse addPayment(Paymentdto paymentdto);
    PaymentResponse updatePayment(Paymentdto paymentdto,Long id);
    public boolean deletePayment(Long id);
}
