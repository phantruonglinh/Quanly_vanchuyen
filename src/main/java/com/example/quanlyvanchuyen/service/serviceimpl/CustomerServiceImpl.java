package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.BatchResponse;
import com.example.quanlyvanchuyen.DTO.CustomerResponse;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.BatchMapper;
import com.example.quanlyvanchuyen.mapper.CustomerMapper;
import com.example.quanlyvanchuyen.mapper.OrderMapper;
import com.example.quanlyvanchuyen.repository.CustomerRepository;
import com.example.quanlyvanchuyen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<CustomerResponse> listCustomer() {
        return CustomerMapper.MAPPER.mapToListCustomerResponse(customerRepository.findAll());
    }

    @Override
    public CustomerResponse addCustomer(Customerdto customerdto) {
        Customer customer = CustomerMapper.MAPPER.mapToCustomer(customerdto);
        return CustomerMapper.MAPPER.mapToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse updateCustomer(Customerdto customerdto, Long id) {
        Customer ex = customerRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Not Found Customer"));
        Customer customer = CustomerMapper.MAPPER.mapToCustomer(customerdto);
        customer.setCustomerID(ex.getCustomerID());
        return CustomerMapper.MAPPER.mapToCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Customer not found"));
        customerRepository.delete(customer);
        return true;
    }
}
