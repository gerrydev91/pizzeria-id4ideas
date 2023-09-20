package com.remolo.pizzeriadonremolo.services;

import java.util.List;

import com.remolo.pizzeriadonremolo.entities.Orders;

public interface OrderService {

    Orders createOrder(Orders Order);

    Orders UpdateOrder (Integer orderId, Orders updatedOrder);

    List<Orders> getAllOrders();

    List<Orders> byUserId();


    
}
