package com.remolo.pizzeriadonremolo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  userId; 

    @Column(unique = true)
    private String userName;

    @Column
    private String password;

    @Column
    private String name; 

    @Column
    private String lastName; 

    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "users", cascade= CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();


    @OneToMany(mappedBy = "users", cascade= CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    }

