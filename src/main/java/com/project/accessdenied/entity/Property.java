package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    int numberOfBedrooms;
    int numberOfBathrooms;
    int rentAmount;
    int securityDepositAmount;
    boolean isOccupied;

    //List<String> photos;
    @ManyToOne
    User ownedBy;
    @OneToOne
    User lastRentedBy;


}
