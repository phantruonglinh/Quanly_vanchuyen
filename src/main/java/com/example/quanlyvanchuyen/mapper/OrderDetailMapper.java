package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.OrderDetailResponse;
import com.example.quanlyvanchuyen.DTO.OrderDetaildto;
import com.example.quanlyvanchuyen.DTO.OrderResponse;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.entity.OrderDetail;
import com.example.quanlyvanchuyen.repository.OrderDetailRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    OrderDetailMapper MAPPER = Mappers.getMapper(OrderDetailMapper.class);
    OrderDetail mapToOrderDetail(OrderDetaildto orderDetaildto);
    OrderDetailResponse mapToOrderDetailResponse(OrderDetail orderDetail);
    List<OrderDetailResponse> mapToListOrderDetailResponse(List<OrderDetail> orderDetails);
}
