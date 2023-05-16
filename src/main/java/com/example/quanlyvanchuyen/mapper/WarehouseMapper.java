package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.WarehouseResponse;
import com.example.quanlyvanchuyen.DTO.Warehousedto;
import com.example.quanlyvanchuyen.entity.Warehouse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    WarehouseMapper MAPPER = Mappers.getMapper(WarehouseMapper.class);
    Warehouse mapToWarehouse(Warehousedto warehousedto);
    List<WarehouseResponse> mapToListWarehouseResponse(List<Warehouse> warehouses);
    WarehouseResponse mapToWarehouseResponse(Warehouse warehouse);
}
