package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String email;
    String firstName;
    String lastname;
    String password;
    //Role role;
    LocalDateTime LastLoggedInAt;
    Boolean active;
    @OneToMany
    List<Property> properties;

}
