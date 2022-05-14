package com.project.accessdenied.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
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
    @JsonIgnore
    private City city;
    //addition
    @OneToMany
    @JsonIgnore
    private List<RentPeriod> rentPeriods;

    @OneToOne
    PropertyType propertyType;

}
