package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.TransportVehicleResponse;
import com.example.quanlyvanchuyen.DTO.TransportVehicledto;
import com.example.quanlyvanchuyen.entity.TransportVehicle;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransportVehicleMapper {
    TransportVehicleMapper MAPPER = Mappers.getMapper(TransportVehicleMapper.class);
    TransportVehicle mapToTransportVehicle(TransportVehicledto transportVehicledto);
    List<TransportVehicleResponse> mapToListTransportVehicleResponse(List<TransportVehicle> transportVehicles);
    TransportVehicleResponse mapToTransportVehicleResponse(TransportVehicle transportVehicle);
}
