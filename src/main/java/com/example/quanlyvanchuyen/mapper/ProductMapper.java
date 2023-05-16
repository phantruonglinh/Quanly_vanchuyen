package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.ProductResponse;
import com.example.quanlyvanchuyen.DTO.Productdto;
import com.example.quanlyvanchuyen.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
    Product mapToProduct(Productdto productdto);
    List<ProductResponse> mapToListProductResponse(List<Product> products);
    ProductResponse mapToProductResponse(Product product);
}
