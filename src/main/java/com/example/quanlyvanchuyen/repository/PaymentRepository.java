package com.example.quanlyvanchuyen.repository;

import com.example.quanlyvanchuyen.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
