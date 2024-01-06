package com.remolo.pizzeriadonremolo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remolo.pizzeriadonremolo.dto.CategoryDTO;
import com.remolo.pizzeriadonremolo.dto.ProductDTO;
import com.remolo.pizzeriadonremolo.services.CategoryService;
import com.remolo.pizzeriadonremolo.services.ProductService;

@RestController
@RequestMapping("/api/v1/")
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDTO>> getCategories(){
        List<CategoryDTO> categoriesDTO = categoryService.getCategories();

        if (categoriesDTO != null && !categoriesDTO.isEmpty()){
            return new ResponseEntity<>(categoriesDTO, HttpStatus.OK);            
        }else{
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Integer categoryId){

        List<ProductDTO> productsDTOs = productService.getProductsByCategory(categoryId);
        if (productsDTOs != null && !productsDTOs.isEmpty()){
            return new ResponseEntity<>(productsDTOs, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



    }



    
}
