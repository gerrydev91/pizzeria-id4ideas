package com.remolo.pizzeriadonremolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.remolo.pizzeriadonremolo.entities.Product;
import java.util.List;




public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategory(Integer categoryId);
    
}
