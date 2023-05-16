package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.CustomerResponse;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> listCustomer();
    CustomerResponse addCustomer(Customerdto customerdto);
    CustomerResponse updateCustomer(Customerdto customerdto, Long id);
    public boolean deleteCustomer(Long id);
}
