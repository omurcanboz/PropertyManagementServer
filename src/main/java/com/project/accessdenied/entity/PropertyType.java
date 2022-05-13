package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;
}
