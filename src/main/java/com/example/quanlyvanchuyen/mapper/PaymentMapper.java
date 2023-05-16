package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.PaymentResponse;
import com.example.quanlyvanchuyen.DTO.Paymentdto;
import com.example.quanlyvanchuyen.entity.Payment;
import com.example.quanlyvanchuyen.repository.PaymentRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMapper {
    PaymentMapper MAPPER = Mappers.getMapper(PaymentMapper.class);
    Payment mapToPayment(Paymentdto paymentdto);
    List<PaymentResponse> mapToListPaymentResponse(List<Payment> payments);
    PaymentResponse mapToPaymentResponse(Payment payment);
}
