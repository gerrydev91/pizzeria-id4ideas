package com.remolo.pizzeriadonremolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remolo.pizzeriadonremolo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
