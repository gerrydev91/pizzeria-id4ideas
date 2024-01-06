package com.remolo.pizzeriadonremolo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.remolo.pizzeriadonremolo.entities.Orders;

public interface OrdersRepository extends JpaRepository <Orders, Long> {



   /*
   @Query("SELECT c FROM Orders c LEFT JOIN FETCH c.orderItem")
    List<Orders> findAllOrdersItems();

     @Query("SELECT o FROM Orders o LEFT JOIN FETCH o.orderItems WHERE o.orderId = :orderId")
    Orders findOrderWithOrderItems(@Param("orderId") Long orderId);
   */  

    
    
}
