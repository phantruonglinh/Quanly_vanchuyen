package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")

public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping
    public ResponseEntity<?> getAllOrder(){
      return ResponseEntity.status(HttpStatus.OK).body(orderService.listOrder());
    }
    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody Orderdto orderdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(orderdto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@RequestBody Orderdto orderdto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderdto, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id){
        if(orderService.deleteOrder(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
