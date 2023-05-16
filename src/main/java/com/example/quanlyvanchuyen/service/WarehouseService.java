package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.DTO.WarehouseResponse;
import com.example.quanlyvanchuyen.DTO.Warehousedto;
import com.example.quanlyvanchuyen.repository.WarehouseRepository;

import java.util.List;

public interface WarehouseService {
    List<WarehouseResponse> listWarehouse();
    WarehouseResponse addWarehouse(Warehousedto warehousedto);
    WarehouseResponse updateWarehouse(Warehousedto warehousedto,Long id);
    public boolean deleteWarehouse(Long id);
}
