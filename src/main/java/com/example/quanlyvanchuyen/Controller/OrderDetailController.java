package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.OrderDetailResponse;
import com.example.quanlyvanchuyen.DTO.OrderDetaildto;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.entity.Order;
import com.example.quanlyvanchuyen.entity.OrderDetail;
import com.example.quanlyvanchuyen.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @GetMapping
    public ResponseEntity<?> getAllOrderDetail(){
        return ResponseEntity.status(HttpStatus.OK).body(orderDetailService.listOrderDetail());
    }
    @PostMapping
    public ResponseEntity<?> addOrderDetail(@RequestBody OrderDetaildto orderDetaildto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDetailService.addOrderDetail(orderDetaildto));
    }
    @PutMapping("/{id}")
    public OrderDetailResponse updateOrderDetail(@RequestBody OrderDetaildto orderDetaildto, @PathVariable Long id) {
        return orderDetailService.updateOrderDetail(orderDetaildto, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable Long id){
        if(orderDetailService.deleteOrderDetail(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
