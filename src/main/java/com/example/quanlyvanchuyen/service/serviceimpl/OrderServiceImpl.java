package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.OrderResponse;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.MapOrder;
import com.example.quanlyvanchuyen.mapper.OrderMapper;
import com.example.quanlyvanchuyen.repository.CustomerRepository;
import com.example.quanlyvanchuyen.repository.OrderRepository;
import com.example.quanlyvanchuyen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<OrderResponse> listOrder() {

        return new MapOrder().mapToListOrderResponse(orderRepository.findAll());
    }

    @Override
    public OrderResponse addOrder(Orderdto orderdto) {
        Order order = new Order();
        Customer customer = customerRepository.findById(orderdto.getCustomerID()).orElseThrow(() -> new DataNotFoundException("Customer not found"));
        order.setDeliveryDate(orderdto.getDeliveryDate());
        order.setOrderDate(orderdto.getOrderDate());
        order.setTotalAmount(orderdto.getTotalAmount());
        order.setCustomer(customer);
        orderRepository.save(order);
        return new MapOrder().mapToOrderResponse(order);
    }

    @Override
    public OrderResponse updateOrder(Orderdto orderdto, Long id) {
        Order ex = orderRepository.findById(id).
                orElseThrow(()-> new DataNotFoundException("Order not found"));
        Order order = OrderMapper.MAPPER.mapToOrder(orderdto);
        order.setOrderID(ex.getOrderID());
        orderRepository.save(order);
        return new MapOrder().mapToOrderResponse(order);
    }

    @Override
    public boolean deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Order not found"));
        orderRepository.delete(order);
        return true;
    }
}
