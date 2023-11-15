package com.remolo.pizzeriadonremolo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.remolo.pizzeriadonremolo.entities.Orders;

public interface OrdersRepository extends JpaRepository <Orders, Long> {

    
    
}
