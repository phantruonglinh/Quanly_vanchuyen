package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.OrderResponse;
import com.example.quanlyvanchuyen.DTO.Orderdto;
import com.example.quanlyvanchuyen.DTO.PaymentResponse;
import com.example.quanlyvanchuyen.DTO.Paymentdto;
import com.example.quanlyvanchuyen.repository.PaymentRepository;
import com.example.quanlyvanchuyen.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping
    public ResponseEntity<?> getAllPayment(){
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.listPayment());
    }
    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody Paymentdto paymentdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.addPayment(paymentdto));
    }
    @PutMapping("/{id}")
    public PaymentResponse updatePayment(@RequestBody Paymentdto paymentdto, @PathVariable Long id) {
        return paymentService.updatePayment(paymentdto, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id){
        if(paymentService.deletePayment(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
