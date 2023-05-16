package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.BatchResponse;
import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.OrderDetailResponse;
import com.example.quanlyvanchuyen.DTO.OrderDetaildto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailResponse> listOrderDetail();
    OrderDetailResponse addOrderDetail(OrderDetaildto orderDetaildto);
    OrderDetailResponse updateOrderDetail(OrderDetaildto orderDetaildto,Long id);

    public boolean deleteOrderDetail(Long id);
}
