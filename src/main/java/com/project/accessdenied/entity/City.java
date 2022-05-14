package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    //private int zipCode;

    @OneToOne
    private State state;

    @OneToMany(mappedBy = "city")
    private List<Property> properties;


}
