package com.remolo.pizzeriadonremolo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.remolo.pizzeriadonremolo.entities.Orders;

public interface OrdersRepository extends JpaRepository <Orders, Long> {

    
}
