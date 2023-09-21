package com.remolo.pizzeriadonremolo.dto;

import com.remolo.pizzeriadonremolo.entities.Address;
import com.remolo.pizzeriadonremolo.entities.User;

public class UserAddressDTO {

    private User user;

    private Address address;

    public User getUser(){
        return user;
    }

    public Address getAddress(){
        return address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    


    
}
