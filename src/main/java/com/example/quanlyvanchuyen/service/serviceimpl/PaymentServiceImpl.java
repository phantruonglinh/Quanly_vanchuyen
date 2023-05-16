package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.*;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.entity.OrderDetail;
import com.example.quanlyvanchuyen.entity.Payment;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.CustomerMapper;
import com.example.quanlyvanchuyen.mapper.OrderDetailMapper;
import com.example.quanlyvanchuyen.mapper.PaymentMapper;
import com.example.quanlyvanchuyen.repository.PaymentRepository;
import com.example.quanlyvanchuyen.service.PaymentService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    PaymentRepository paymentRepository;


    @Override
    public List<PaymentResponse> listPayment() {
        return PaymentMapper.MAPPER.mapToListPaymentResponse(paymentRepository.findAll());

    }

    @Override
    public PaymentResponse addPayment(Paymentdto paymentdto) {
            Payment payment = PaymentMapper.MAPPER.mapToPayment(paymentdto);
            return PaymentMapper.MAPPER.mapToPaymentResponse(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponse updatePayment(Paymentdto paymentdto, Long id) {
        Payment ex = paymentRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Batch not found"));
        Payment payment = PaymentMapper.MAPPER.mapToPayment(paymentdto);
        payment.setPaymentID(ex.getPaymentID());
        return PaymentMapper.MAPPER.mapToPaymentResponse(paymentRepository.save(payment));
    }

    @Override
    public boolean deletePayment(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Order not found"));
        paymentRepository.delete(payment);
        return true;
    }
}
