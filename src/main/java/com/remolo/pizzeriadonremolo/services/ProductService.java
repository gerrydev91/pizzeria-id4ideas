package com.remolo.pizzeriadonremolo.services;

import java.util.List;

import com.remolo.pizzeriadonremolo.dto.ProductDTO;

public interface ProductService {

    public List<ProductDTO> getProductsByCategory(Integer id);

    public List<ProductDTO> getProductByName (String productName);

  

}
