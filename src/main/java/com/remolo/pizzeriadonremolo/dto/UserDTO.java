package com.remolo.pizzeriadonremolo.dto;

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
}
