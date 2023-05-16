package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.*;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.entity.OrderDetail;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.BatchMapper;
import com.example.quanlyvanchuyen.mapper.CustomerMapper;
import com.example.quanlyvanchuyen.mapper.OrderDetailMapper;
import com.example.quanlyvanchuyen.repository.OrderDetailRepository;
import com.example.quanlyvanchuyen.service.OrderDetailService;
import com.example.quanlyvanchuyen.service.OrderService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;


    @Override
    public List<OrderDetailResponse> listOrderDetail() {
        return OrderDetailMapper.MAPPER.mapToListOrderDetailResponse(orderDetailRepository.findAll());
    }

    @Override
    public OrderDetailResponse addOrderDetail(OrderDetaildto orderDetaildto) {
        OrderDetail orderDetail = OrderDetailMapper.MAPPER.mapToOrderDetail(orderDetaildto);
        return OrderDetailMapper.MAPPER.mapToOrderDetailResponse(orderDetailRepository.save(orderDetail));
    }

    @Override
    public OrderDetailResponse updateOrderDetail(OrderDetaildto orderDetaildto, Long id) {

        OrderDetail ex = orderDetailRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Batch not found"));
        OrderDetail orderDetail = OrderDetailMapper.MAPPER.mapToOrderDetail(orderDetaildto);
        orderDetail.setOrderDetailID(ex.getOrderDetailID());
        return OrderDetailMapper.MAPPER.mapToOrderDetailResponse(orderDetailRepository.save(orderDetail));
    }

    @Override
    public boolean deleteOrderDetail(Long id) {

        OrderDetail orderDetail = orderDetailRepository.findById(id).orElseThrow(() -> new DataNotFoundException("ordetail not found"));
        orderDetailRepository.delete(orderDetail);
        return true;
    }
}
//    @Override
//    public List<OrderDetaildto> listOrderDetail() {
//        return OrderDetailMapper.MAPPER.mapToListOrderDetailResponse(OrderDetailRepositor.);
//    }
//
//    @Override
//    public CustomerResponse addCustomer(Customerdto customerdto) {
//        Customer customer = CustomerMapper.MAPPER.mapToCustomer(customerdto);
//        return CustomerMapper.MAPPER.mapToCustomerResponse(customerRepository.save(customer));
//    }
//
//    @Override
//    public CustomerResponse updateCustomer(Customerdto customerdto, Long id) {
//        Customer ex = customerRepository.findById(id)
//                .orElseThrow(() -> new DataNotFoundException("Not Found Customer"));
//        Customer customer = CustomerMapper.MAPPER.mapToCustomer(customerdto);
//        customer.setCustomerID(ex.getCustomerID());
//        return CustomerMapper.MAPPER.mapToCustomerResponse(customerRepository.save(customer));
//    }
//
//    @Override
//    public boolean deleteCustomer(Long id) {
//        Customer customer = customerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Customer not found"));
//        customerRepository.delete(customer);
//        return true;
//    }
//}
//
//}
