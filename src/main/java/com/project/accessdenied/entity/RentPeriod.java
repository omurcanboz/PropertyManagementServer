package com.project.accessdenied.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class RentPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate rentedAt;
    private LocalDate rentStarts;
    private LocalDate rentEnds;
    @OneToOne
    private User tenant;

}
