package com.example.quanlyvanchuyen.repository;

import com.example.quanlyvanchuyen.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
