package com.remolo.pizzeriadonremolo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO implements Serializable{

    private String categoryName; 

    private List<ProductDTO> products = new ArrayList<>();

    
}
