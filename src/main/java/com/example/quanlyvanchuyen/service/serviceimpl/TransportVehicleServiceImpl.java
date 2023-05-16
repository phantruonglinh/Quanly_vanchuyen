package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.TransportVehicleResponse;
import com.example.quanlyvanchuyen.DTO.TransportVehicledto;
import com.example.quanlyvanchuyen.entity.Product;
import com.example.quanlyvanchuyen.entity.TransportVehicle;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.ProductMapper;
import com.example.quanlyvanchuyen.mapper.TransportVehicleMapper;
import com.example.quanlyvanchuyen.repository.TransportVehicleRepository;
import com.example.quanlyvanchuyen.service.TransportVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportVehicleServiceImpl implements TransportVehicleService {
    @Autowired
    TransportVehicleRepository transportVehicleRepository;
    @Override
    public List<TransportVehicleResponse> listTransportVehicle() {
        return TransportVehicleMapper.MAPPER.mapToListTransportVehicleResponse(transportVehicleRepository.findAll());
    }

    @Override
    public TransportVehicleResponse addTransportVehicle(TransportVehicledto transportVehicledto) {
        TransportVehicle transportVehicle = TransportVehicleMapper.MAPPER.mapToTransportVehicle(transportVehicledto);
        return TransportVehicleMapper.MAPPER.mapToTransportVehicleResponse(transportVehicleRepository.save(transportVehicle));
    }

    @Override
    public TransportVehicleResponse updateTransportVehicle(TransportVehicledto transportVehicledto, Long id) {
        TransportVehicle ex = transportVehicleRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("TransportVehicle not found"));
        TransportVehicle transportVehicle = TransportVehicleMapper.MAPPER.mapToTransportVehicle(transportVehicledto);
        transportVehicle.setTransportVehicleID(ex.getTransportVehicleID());
        return TransportVehicleMapper.MAPPER.mapToTransportVehicleResponse(transportVehicleRepository.save(transportVehicle));
    }

    @Override
    public boolean deleteTransportVehicle(Long id) {
        TransportVehicle transportVehicle = transportVehicleRepository.findById(id).orElseThrow(() -> new DataNotFoundException("transportvehicle not found"));
        transportVehicleRepository.delete(transportVehicle);
        return true;
    }
}
