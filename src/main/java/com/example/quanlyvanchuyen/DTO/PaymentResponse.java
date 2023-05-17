package com.example.quanlyvanchuyen.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponse {
    private Long paymentID;

    private String paymentMethod;

    private String paymentAmount;

    private String paymentDate;

    private String paymentStatus;
}
