package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;

import java.util.List;

public interface ProductService {
    List<ProductResponse> listProduct();
    ProductResponse addProduct(Productdto productdto);
    ProductResponse updateProduct(Productdto productdto,Long id);
    public boolean deleteProduct(Long id);
}
