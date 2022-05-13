package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @ManyToOne
    City city;

    @OneToMany
    List<Property> properties;

}
