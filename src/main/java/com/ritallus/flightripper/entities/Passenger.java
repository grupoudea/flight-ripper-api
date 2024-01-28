package com.ritallus.flightripper.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "passenger")
@Entity
@Data
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "document")
    private String document;

    @Column(name = "full_name")
    private String fullName;

}
