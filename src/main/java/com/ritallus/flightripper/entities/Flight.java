package com.ritallus.flightripper.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "flight")
@Entity
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flight_number")
    private String flighNumber;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "date_time_departure")
    private LocalDateTime dateTimeDeparture;

    @Column(name = "date_time_arrival")
    private LocalDateTime dateTimeArrival;
}
