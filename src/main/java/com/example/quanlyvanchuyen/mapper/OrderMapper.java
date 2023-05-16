package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.DTO.OrderResponse;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);
    Order mapToOrder(Orderdto orderdto);
    Orderdto mapToOrderDTO(Order order);

    List<OrderResponse> mapToListOrderResponse(List<Order> orders);
}
