package com.example.quanlyvanchuyen.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private Long customerID;

    private String customerName;

    private String email;

    private String phoneNumber;

    private String address;
}
