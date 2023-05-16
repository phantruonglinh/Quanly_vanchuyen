package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.WarehouseResponse;
import com.example.quanlyvanchuyen.DTO.Warehousedto;
import com.example.quanlyvanchuyen.entity.Product;
import com.example.quanlyvanchuyen.entity.Warehouse;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.ProductMapper;
import com.example.quanlyvanchuyen.mapper.WarehouseMapper;
import com.example.quanlyvanchuyen.repository.WarehouseRepository;
import com.example.quanlyvanchuyen.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public List<WarehouseResponse> listWarehouse() {
        return WarehouseMapper.MAPPER.mapToListWarehouseResponse(warehouseRepository.findAll());
    }

    @Override
    public WarehouseResponse addWarehouse(Warehousedto warehousedto) {
        Warehouse warehouse = WarehouseMapper.MAPPER.mapToWarehouse(warehousedto);
        return WarehouseMapper.MAPPER.mapToWarehouseResponse(warehouseRepository.save(warehouse));
    }


    @Override
    public WarehouseResponse updateWarehouse(Warehousedto warehousedto, Long id) {
        Warehouse ex = warehouseRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Warehouse not found"));
        Warehouse warehouse = WarehouseMapper.MAPPER.mapToWarehouse(warehousedto);
        warehouse.setWarehouseID(ex.getWarehouseID());
        return WarehouseMapper.MAPPER.mapToWarehouseResponse(warehouseRepository.save(warehouse));
    }

    @Override
    public boolean deleteWarehouse(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Warehouse not found"));
        warehouseRepository.delete(warehouse);
        return true;
    }
}
