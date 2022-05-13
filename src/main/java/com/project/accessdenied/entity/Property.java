package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @ElementCollection
    List<String> photos;
    @ManyToOne
    User ownedBy;
    @OneToOne
    User lastRentedBy;
    @ManyToOne
    City city;
    @ManyToOne
    State state;
    //addition
    @OneToMany
    List<RentPeriod> rentPeriods;

}
