package com.remolo.pizzeriadonremolo.dto;

import com.remolo.pizzeriadonremolo.entities.Orders;
import com.remolo.pizzeriadonremolo.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemDTO {

    private Product product;
    private Integer quantity;
    private Orders orders;


}
