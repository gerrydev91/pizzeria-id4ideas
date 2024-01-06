package com.remolo.pizzeriadonremolo.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remolo.pizzeriadonremolo.dto.AddressDTO;
import com.remolo.pizzeriadonremolo.dto.UserDTO;
import com.remolo.pizzeriadonremolo.entities.User;
import com.remolo.pizzeriadonremolo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
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
    public UserDTO getUserByPhone(String phoneNumber) {

        if (phoneNumber == null) {

            throw new IllegalArgumentException("The phone number cannot be empty");
        }

        String phoneN = phoneNumber;
        StringBuilder phoneCleaned = new StringBuilder();
        for (int i=0; i<phoneN.length(); i++){
            char c = phoneN.charAt(i);
            if(Character.isDigit(c)){
                phoneCleaned.append(c);
            }

            
        }

        User user = userRepository.getUserByPhoneNumber(phoneCleaned.toString());
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);


        return userDTO;
    }

    @Override
    public User updateUser(User user) {

        userRepository.save(user);

        return user;
    }

    @Override
    public List<UserDTO> listAllUsersWithAddress() {
        List<User> users = userRepository.findAllWithAddress();
        if(users.isEmpty()){
            return Collections.emptyList();
        }
    
        return users.stream()
            .map(user -> {
                List<AddressDTO> addressDTOs = user.getAddresses().stream()
                .map(address -> modelMapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setAddresses(addressDTOs);
        return userDTO;
            })
            .collect(Collectors.toList());
}

}
