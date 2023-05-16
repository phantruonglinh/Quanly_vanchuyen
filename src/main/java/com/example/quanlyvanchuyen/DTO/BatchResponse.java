package com.example.quanlyvanchuyen.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchResponse {

    private String batchDate;

    private String quantity;

    private Batchdto batchdto;
}
