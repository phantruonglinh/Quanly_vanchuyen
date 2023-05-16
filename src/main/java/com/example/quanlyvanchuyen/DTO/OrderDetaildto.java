package com.example.quanlyvanchuyen.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetaildto {

    private Long orderDetailID;

    private String quantity;

    private String unitPrice;

    private Long OrderID;
}
