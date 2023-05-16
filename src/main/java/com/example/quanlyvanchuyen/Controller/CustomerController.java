package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.Customerdto;
import com.example.quanlyvanchuyen.entity.Customer;
import com.example.quanlyvanchuyen.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllCustomer() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.listCustomer());
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customerdto customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customerdto customer, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customer,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        if(customerService.deleteCustomer(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
