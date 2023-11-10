package com.remolo.pizzeriadonremolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.remolo.pizzeriadonremolo.entities.Category;
import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Integer>{

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.products")
    List<Category> findAllWithProducts();

    List<Category> findByName(String name);



}
