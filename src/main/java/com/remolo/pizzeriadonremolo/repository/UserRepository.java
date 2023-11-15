package com.remolo.pizzeriadonremolo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.remolo.pizzeriadonremolo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

     @Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.addresses")
    List<User> findAllWithAddress();

    User getUserByPhoneNumber (String phoneNumber);
}
