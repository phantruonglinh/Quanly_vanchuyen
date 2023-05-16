package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.entity.OrderDetail;
import com.example.quanlyvanchuyen.entity.Product;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.OrderDetailMapper;
import com.example.quanlyvanchuyen.mapper.ProductMapper;
import com.example.quanlyvanchuyen.repository.ProductRepository;
import com.example.quanlyvanchuyen.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductResponse> listProduct() {
        return ProductMapper.MAPPER.mapToListProductResponse(productRepository.findAll());
    }

    @Override
    public ProductResponse addProduct(Productdto productdto) {
        Product product = ProductMapper.MAPPER.mapToProduct(productdto);
        return ProductMapper.MAPPER.mapToProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse updateProduct(Productdto productdto, Long id) {
        Product ex = productRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Batch not found"));
        Product product = ProductMapper.MAPPER.mapToProduct(productdto);
        product.setProductID(ex.getProductID());
        return ProductMapper.MAPPER.mapToProductResponse(productRepository.save(product));
    }

    @Override
    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("ordetail not found"));
        productRepository.delete(product);
        return true;
    }
}
