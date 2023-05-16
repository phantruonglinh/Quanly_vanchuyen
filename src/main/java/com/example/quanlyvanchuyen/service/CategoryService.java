package com.example.quanlyvanchuyen.service;

import com.example.quanlyvanchuyen.DTO.*;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> listCategory();
    CategoryResponse addCategory(Categorydto categorydto);
    CategoryResponse updateCategory(Categorydto categorydto,Long id);
    public boolean deleteCategory(Long id);
}
