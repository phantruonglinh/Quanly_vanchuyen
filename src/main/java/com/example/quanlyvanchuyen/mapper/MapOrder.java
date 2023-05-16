package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.OrderResponse;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class MapOrder {

    public OrderResponse mapToOrderResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponse orderResponse = new OrderResponse();

        orderResponse.setOrderID( order.getOrderID() );
        orderResponse.setOrderDate( order.getOrderDate() );
        orderResponse.setDeliveryDate( order.getDeliveryDate() );
        orderResponse.setTotalAmount( order.getTotalAmount() );
        //them tuong tu
        orderResponse.setCustomerResponse( CustomerMapper.MAPPER.mapToCustomerResponse(order.getCustomer()));
        return orderResponse;
    }
    public List<OrderResponse> mapToListOrderResponse(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderResponse> list = new ArrayList<OrderResponse>( orders.size() );
        for ( Order order : orders ) {
            list.add( mapToOrderResponse( order ) );
        }
        return list;
    }
}
