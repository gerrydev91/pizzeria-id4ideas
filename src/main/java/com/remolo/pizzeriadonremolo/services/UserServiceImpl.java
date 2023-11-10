package com.remolo.pizzeriadonremolo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.remolo.pizzeriadonremolo.dto.UserAddressDTO;
import com.remolo.pizzeriadonremolo.entities.Address;
import com.remolo.pizzeriadonremolo.entities.User;
import com.remolo.pizzeriadonremolo.repository.AddressRepository;
import com.remolo.pizzeriadonremolo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    

    public UserServiceImpl(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
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

    // @Override
    // @Transactional
    // public User createUserWithAddress(UserAddressDTO userAddressDTO) {
    //     User user = userAddressDTO.getUser();
    //     Address address = userAddressDTO.getAddress();
    //     address = addressRepository.save(address);
    //     user.getAddresses().add(address);
    //     user = userRepository.save(user);
        
    //     return user;
    // }

    

}
