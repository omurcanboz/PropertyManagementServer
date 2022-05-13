package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class RentPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    LocalDate rentedAt;
    LocalDate rentStarts;
    LocalDate rentEnds;
    @OneToOne
    User tenant;

}
