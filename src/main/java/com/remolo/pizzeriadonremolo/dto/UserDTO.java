package com.remolo.pizzeriadonremolo.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
 
    private String name;
    private String lastName;
    private String phoneNumber;
    private String street;
    private String city;
    private String postalCode;

    private List<AddressDTO> addresses = new ArrayList<>();
   
}
