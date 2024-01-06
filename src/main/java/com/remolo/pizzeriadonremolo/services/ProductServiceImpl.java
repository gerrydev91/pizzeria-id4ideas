package com.remolo.pizzeriadonremolo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.remolo.pizzeriadonremolo.dto.ProductDTO;
import com.remolo.pizzeriadonremolo.entities.Category;
import com.remolo.pizzeriadonremolo.repository.CategoryRepository;

@Service
public class ProductServiceImpl implements ProductService {

    CategoryRepository categoryRepository;
    ModelMapper modelMapper;

    

    public ProductServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(Integer id) {

        Optional<Category> optCategory = categoryRepository.findById(id);

        if (optCategory.isEmpty() || optCategory.get().getProducts().isEmpty()) {
            return new ArrayList<>();
        }

        List<ProductDTO> productDTOs = optCategory.get().getProducts().stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());

        return productDTOs;

    }

    @Override
    public List<ProductDTO> getProductByName(String productName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductByName'");
    }

}
