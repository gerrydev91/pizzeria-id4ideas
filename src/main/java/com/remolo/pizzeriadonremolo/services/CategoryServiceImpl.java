package com.remolo.pizzeriadonremolo.services;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remolo.pizzeriadonremolo.dto.CategoryDTO;
import com.remolo.pizzeriadonremolo.dto.ProductDTO;
import com.remolo.pizzeriadonremolo.entities.Category;
import com.remolo.pizzeriadonremolo.repository.CategoryRepository;
import com.remolo.pizzeriadonremolo.repository.ProductRepository;
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;  
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
         this.modelMapper = modelMapper;
    }




    @Override
    public List<CategoryDTO> getCategories() {
         List<Category> categories = categoryRepository.findAll();
         if(categories.isEmpty()){
            return null;
         }

        List<CategoryDTO> categoriesDTOs = categories.stream()
        .map(category-> modelMapper.map(category, CategoryDTO.class))
        .collect(Collectors.toList());

         List<Category> categoriesWithProducts = categoryRepository.findAllWithProducts();

         for(Category category : categoriesWithProducts){
            List<ProductDTO> productDTOs = category.getProducts().stream()
            .map(product -> modelMapper.map(product, ProductDTO.class))
            .collect(Collectors.toList());

            CategoryDTO matchingCategoryDTO = categoriesDTOs.stream()
                .filter(categoryDTO -> categoryDTO.getCategoryName().equals(category.getName()))
                .findFirst()
                .orElse(null);
            if(matchingCategoryDTO != null){
                matchingCategoryDTO.setProducts(productDTOs);
            }
         }

         return categoriesDTOs;

    }
    
}
