package com.remolo.pizzeriadonremolo.services;

import java.util.List;

import com.remolo.pizzeriadonremolo.entities.User;

public interface UserService {

    User create(User user);

    void deleteUser(Integer userId);

    User getUserByPhone(String phoneNumber);

    User updateUser(User user);

    List<User>listAllUsers();

    

}
