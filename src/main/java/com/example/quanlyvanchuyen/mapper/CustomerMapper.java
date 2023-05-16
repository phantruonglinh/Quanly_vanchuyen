package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.CustomerResponse;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);
    Customer mapToCustomer(Customerdto customerdto);
    CustomerResponse mapToCustomerResponse(Customer customer);
    List<CustomerResponse> mapToListCustomerResponse(List<Customer> customers);
}
