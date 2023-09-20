package com.remolo.pizzeriadonremolo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.remolo.pizzeriadonremolo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
    
}
