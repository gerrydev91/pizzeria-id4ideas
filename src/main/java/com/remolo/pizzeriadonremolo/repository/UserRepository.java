package com.remolo.pizzeriadonremolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remolo.pizzeriadonremolo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    

    User getUserByPhoneNumber (String phoneNumber);
}
