package com.ritallus.flightripper.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "passenger")
@Entity
@Data
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "document")
    private String document;

    @Column(name = "full_name")
    private String fullName;

}
