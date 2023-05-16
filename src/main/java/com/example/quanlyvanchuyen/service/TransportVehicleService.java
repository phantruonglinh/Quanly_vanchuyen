package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.DTO.TransportVehicleResponse;
import com.example.quanlyvanchuyen.DTO.TransportVehicledto;
import com.example.quanlyvanchuyen.entity.TransportVehicle;
import com.example.quanlyvanchuyen.repository.TransportVehicleRepository;

import java.util.List;

public interface TransportVehicleService {
    List<TransportVehicleResponse> listTransportVehicle();
    TransportVehicleResponse addTransportVehicle(TransportVehicledto transportVehicledto);
    TransportVehicleResponse updateTransportVehicle(TransportVehicledto transportVehicledto,Long id);
    public boolean deleteTransportVehicle(Long id);
}
