package com.remolo.pizzeriadonremolo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remolo.pizzeriadonremolo.dto.CategoryDTO;
import com.remolo.pizzeriadonremolo.services.CategoryService;

@RestController("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<CategoryDTO> categoriesDTO = categoryService.getCategories();
        
    }
    
}
