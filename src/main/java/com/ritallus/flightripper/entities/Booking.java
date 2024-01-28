package com.ritallus.flightripper.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "booking")
@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_passenger")
    private Integer idPassenger;

    @Column(name = "id_flight")
    private Integer idFlight;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    @Column(name = "comment")
    private String comment;

    /*
    * Relaciones, columnas con tipos de datos que no están en la tabla a nivel de BD
    * */
    @ManyToOne
    @JoinColumn(name = "id_passenger", insertable = false, updatable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "id_flight", insertable = false, updatable = false)
    private Flight flight;





}
