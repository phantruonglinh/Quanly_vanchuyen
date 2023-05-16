package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.listProduct());
    }
    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Productdto productdto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productdto));
    }
    @PutMapping("/{id}")
    public ProductResponse updateProduct(@RequestBody Productdto productdto, @PathVariable Long id) {
        return productService.updateProduct(productdto, id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if(productService.deleteProduct(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
