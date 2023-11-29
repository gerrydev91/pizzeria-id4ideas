package com.remolo.pizzeriadonremolo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remolo.pizzeriadonremolo.dto.UserDTO;
import com.remolo.pizzeriadonremolo.services.UserService;


@RestController
@RequestMapping("/api/v1")
public class UserController {

   
    private final UserService userService;
    
    

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/usersAddresses")
    public ResponseEntity<List<UserDTO>> listAllUsersWithAddress(){
        List<UserDTO> usersWithAddress = userService.listAllUsersWithAddress();
        if(usersWithAddress.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(usersWithAddress, HttpStatus.OK);  
        }


    }
        
    
}
