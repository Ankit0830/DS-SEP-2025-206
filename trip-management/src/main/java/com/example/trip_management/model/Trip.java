package com.example.trip_management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String destination;
    private java.time.LocalDate startDate;
    private java.time.LocalDate endDate;
    private Double price;

    @Enumerated(EnumType.STRING)
    private TripStatus status;
    @Version
    private Long version;
}

