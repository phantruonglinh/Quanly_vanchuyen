package com.example.quanlyvanchuyen.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Orderdto {

    private Long orderID;

    private String orderDate;

    private String deliveryDate;

    private String totalAmount;

    private Long customerID;
}
