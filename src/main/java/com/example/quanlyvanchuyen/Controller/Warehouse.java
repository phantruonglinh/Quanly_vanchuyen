package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.DTO.WarehouseResponse;
import com.example.quanlyvanchuyen.DTO.Warehousedto;
import com.example.quanlyvanchuyen.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/warehouse")
public class Warehouse {
    @Autowired
    WarehouseService warehouseService;
    @GetMapping
    public ResponseEntity<?> getAllWarehouse(){
        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.listWarehouse());
    }
    @PostMapping
    public ResponseEntity<?> addWarehouse(@RequestBody Warehousedto warehousedto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouseService.addWarehouse(warehousedto));
    }
    @PutMapping("/{id}")
    public WarehouseResponse updateWarehouse(@RequestBody Warehousedto warehousedto, @PathVariable Long id) {
        return warehouseService.updateWarehouse(warehousedto, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWarehouse(@PathVariable Long id){
        if(warehouseService.deleteWarehouse(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
