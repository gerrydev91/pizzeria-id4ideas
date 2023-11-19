package com.remolo.pizzeriadonremolo.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.remolo.pizzeriadonremolo.entities.OrderItem;
import com.remolo.pizzeriadonremolo.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private LocalDate datePlaced;

    private LocalDate dateDelivered;

    private List<OrderItem> orderItems = new ArrayList<>();

    private User users;

    private String status; 

    private Double total; 


    
}
