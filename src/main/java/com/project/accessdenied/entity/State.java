package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    @OneToOne(mappedBy = "state")
    private City city;



}
