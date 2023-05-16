package com.example.quanlyvanchuyen.mapper;

import com.example.quanlyvanchuyen.DTO.BatchResponse;
import com.example.quanlyvanchuyen.DTO.CategoryResponse;
import com.example.quanlyvanchuyen.DTO.Categorydto;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {
    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);
    Category mapToCategory(Categorydto categorydto);
    List<CategoryResponse> mapToListCategoryResponse(List<Category> categories);
    CategoryResponse mapToCategoryResponse(Category category);
}
