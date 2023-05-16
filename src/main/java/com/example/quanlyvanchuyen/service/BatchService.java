package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.BatchResponse;
import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.entity.Batch;

import java.util.List;

public interface BatchService {
    List<BatchResponse> listBatch();
    BatchResponse addBatch(Batchdto batchdto);
    BatchResponse updateBatch(Batchdto batchdto,Long id);
    public boolean deleteBatch(Long id);
}
