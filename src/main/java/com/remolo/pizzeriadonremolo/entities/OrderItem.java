package com.remolo.pizzeriadonremolo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders_ITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="Product_id")
    private Product product;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="orders_id")
    private Orders orders;

    protected OrderItem() {
    }

    public OrderItem(Product product, Integer quantity, Orders orders) {
        this.product = product;
        this.quantity = quantity;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orders getorders() {
        return orders;
    }

    public void setorders(Orders orders) {
        this.orders = orders;
    }

    
    
}
