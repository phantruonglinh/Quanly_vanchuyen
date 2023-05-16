package com.example.quanlyvanchuyen.Controller;

import com.example.quanlyvanchuyen.DTO.Batchdto;
import com.example.quanlyvanchuyen.DTO.Categorydto;
import com.example.quanlyvanchuyen.service.CategoryService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.listCategory());
    }

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Categorydto categorydto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.addCategory(categorydto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Categorydto categorydto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(categorydto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        if(categoryService.deleteCategory(id))
        {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete failed", HttpStatus.BAD_REQUEST);
    }
}
