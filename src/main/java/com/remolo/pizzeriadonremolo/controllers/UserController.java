package com.remolo.pizzeriadonremolo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remolo.pizzeriadonremolo.dto.UserDTO;
import com.remolo.pizzeriadonremolo.entities.User;
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

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user){

        if(user.getUserId() !=null){
            return ResponseEntity.badRequest().build();
        }

        User result = userService.create(user);
        return ResponseEntity.ok(result);

        
    }
        
    
}
