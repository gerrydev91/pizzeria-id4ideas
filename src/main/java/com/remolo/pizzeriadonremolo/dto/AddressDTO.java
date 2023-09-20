package com.remolo.pizzeriadonremolo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {
    private Integer id;
    private String Street;
    private String city;
    private String postalCode;

}
