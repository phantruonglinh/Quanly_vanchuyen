package com.example.quanlyvanchuyen.repository;

import com.example.quanlyvanchuyen.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
