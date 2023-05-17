package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.OrderResponse;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Order;

import java.util.List;

public interface OrderService {
    List<OrderResponse> listOrder();
    OrderResponse addOrder(Orderdto orderdto);
    OrderResponse updateOrder(Orderdto orderdto,Long id);
    public boolean deleteOrder(Long id);
}
