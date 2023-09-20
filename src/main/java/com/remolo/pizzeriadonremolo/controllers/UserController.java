package com.remolo.pizzeriadonremolo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remolo.pizzeriadonremolo.entities.User;
import com.remolo.pizzeriadonremolo.services.UserService;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> create (@RequestBody User user){

        if (user.getUserId() != null){
            return ResponseEntity.badRequest().build();
        }

        User result = userService.create(user);
        return ResponseEntity.ok(result);

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
