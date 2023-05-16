package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.BatchResponse;
import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.repository.CustomerRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BatchMapper {
    BatchMapper MAPPER = Mappers.getMapper(BatchMapper.class);
    Batch mapToBatch(Batchdto batchdto);
    List<BatchResponse> mapToListBatchRespose(List<Batch> batches);
    BatchResponse mapToBacthResponse(Batch batch);
}
