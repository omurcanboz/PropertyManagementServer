package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private float rentAmount;
    private float securityDepositAmount;
    private boolean isOccupied;
    private LocalDate lastRentedDate;

    @ElementCollection
    private List<String> photos;
    @ManyToOne
    private User ownedBy;
    @OneToOne
    private User lastRentedBy;
    @ManyToOne
    private City city;
    //addition
    @OneToMany
    private List<RentPeriod> rentPeriods;

}
