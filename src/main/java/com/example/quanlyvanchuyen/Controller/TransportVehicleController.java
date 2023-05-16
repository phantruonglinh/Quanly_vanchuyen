package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.DTO.TransportVehicleResponse;
import com.example.quanlyvanchuyen.DTO.TransportVehicledto;
import com.example.quanlyvanchuyen.service.TransportVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transportvehicle")
public class TransportVehicleController {
    @Autowired
    TransportVehicleService transportVehicleService;
    @GetMapping
    public ResponseEntity<?> getAllTransportVehicle(){
        return ResponseEntity.status(HttpStatus.OK).body(transportVehicleService.listTransportVehicle());
    }
    @PostMapping
    public ResponseEntity<?> addTransportVehicle(@RequestBody TransportVehicledto transportVehicledto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transportVehicleService.addTransportVehicle(transportVehicledto));
    }
    @PutMapping("/{id}")
    public TransportVehicleResponse updateTransportVehicle(@RequestBody TransportVehicledto transportVehicledto, @PathVariable Long id) {
        return transportVehicleService.updateTransportVehicle(transportVehicledto, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransportVehicle(@PathVariable Long id){
        if(transportVehicleService.deleteTransportVehicle(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
