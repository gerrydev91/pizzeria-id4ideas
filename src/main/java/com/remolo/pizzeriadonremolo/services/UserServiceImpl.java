package com.remolo.pizzeriadonremolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remolo.pizzeriadonremolo.entities.User;
import com.remolo.pizzeriadonremolo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {

        userRepository.save(user);
        return user;
    }

    @Override
    public void deleteUser(Integer userId) {

        userRepository.deleteById(userId);
    }

    @Override
    public User getUserByPhone(String phoneNumber) {

        User user = userRepository.getUserByPhoneNumber(phoneNumber);

        return user;
    }

    @Override
    public User updateUser(User user) {

        userRepository.save(user);

        return user;
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
        
    }

    

}
