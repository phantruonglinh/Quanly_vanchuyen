package com.example.quanlyvanchuyen.service.serviceimpl;

import com.example.quanlyvanchuyen.DTO.CategoryResponse;
import com.example.quanlyvanchuyen.DTO.Categorydto;
import com.example.quanlyvanchuyen.entity.Batch;
import com.example.quanlyvanchuyen.entity.Category;
import com.example.quanlyvanchuyen.error.DataNotFoundException;
import com.example.quanlyvanchuyen.mapper.BatchMapper;
import com.example.quanlyvanchuyen.mapper.CategoryMapper;
import com.example.quanlyvanchuyen.repository.CategoryRepository;
import com.example.quanlyvanchuyen.service.CategoryService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> listCategory() {
        return CategoryMapper.MAPPER.mapToListCategoryResponse(categoryRepository.findAll());
    }

    @Override
    public CategoryResponse addCategory(Categorydto categorydto) {
        Category category = CategoryMapper.MAPPER.mapToCategory(categorydto);
        return CategoryMapper.MAPPER.mapToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(Categorydto categorydto, Long id) {
        Category ex = categoryRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Category not found"));
        Category category = CategoryMapper.MAPPER.mapToCategory(categorydto);
        category.setCategoryID(ex.getCategoryID());
        return CategoryMapper.MAPPER.mapToCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public boolean deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException("batch not found"));
        categoryRepository.delete(category);
        return true;
    }
}
