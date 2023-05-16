package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.BatchResponse;
import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.BatchMapper;
import com.example.quanlyvanchuyen.mapper.CustomerMapper;
import com.example.quanlyvanchuyen.repository.BatchRepository;
import com.example.quanlyvanchuyen.repository.CustomerRepository;
import com.example.quanlyvanchuyen.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    BatchRepository batchRepository;

    @Override
    public List<BatchResponse> listBatch() {
        return BatchMapper.MAPPER.mapToListBatchRespose(batchRepository.findAll());
    }

    @Override
    public BatchResponse addBatch(Batchdto batchdto) {
         Batch batch = BatchMapper.MAPPER.mapToBatch(batchdto);
        return BatchMapper.MAPPER.mapToBacthResponse(batchRepository.save(batch));
    }



    @Override
    public BatchResponse updateBatch(Batchdto batchdto, Long id) {
        Batch ex = batchRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Batch not found"));
        Batch batch = BatchMapper.MAPPER.mapToBatch(batchdto);
        batch.setBatchID(ex.getBatchID());
        return BatchMapper.MAPPER.mapToBacthResponse(batchRepository.save(batch));
    }


    @Override
    public boolean deleteBatch(Long id) {

        Batch batch = batchRepository.findById(id).orElseThrow(() -> new DataNotFoundException("batch not found"));
        batchRepository.delete(batch);
        return true;
    }
}
