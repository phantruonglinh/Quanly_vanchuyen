package com.example.quanlyvanchuyen.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long productID;

    private String productName;

    private String unitPrice;

    private Long quantity;

}
