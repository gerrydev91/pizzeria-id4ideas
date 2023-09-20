package com.remolo.pizzeriadonremolo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.remolo.pizzeriadonremolo.entities.Address;
import com.remolo.pizzeriadonremolo.repository.AddressRepository;

@Service(value="adressService")
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address nAddress) {
        
        addressRepository.save(nAddress);

        return nAddress;
    }
    
}
