package com.remolo.pizzeriadonremolo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remolo.pizzeriadonremolo.dto.UserAddressDTO;
import com.remolo.pizzeriadonremolo.entities.Address;
import com.remolo.pizzeriadonremolo.entities.User;
import com.remolo.pizzeriadonremolo.services.UserService;
import com.remolo.pizzeriadonremolo.services.UserServiceImpl;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;


    

    public UserController(UserService userService, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser (@RequestBody UserAddressDTO userAddressDTO){

        User createdUser = userServiceImpl.createUserWithAddress(userAddressDTO);
    
        if (createdUser != null) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listAllUsers(){
        List<User> users= userService.listAllUsers();
        if(users.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }
    
    
}
