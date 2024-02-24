package com.ritallus.flightripper.controllers;


import com.ritallus.flightripper.entities.Booking;
import com.ritallus.flightripper.entities.Passenger;
import com.ritallus.flightripper.services.PassengerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    /**
     * para crear /create
     * para editar /edit
     * para elimnar /delete/{id}
     * para recuperar /get-all
     * para recuperar por id /get-by-id
     */

    @PostMapping("/create")
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {

        var passengerCreated = passengerService.save(passenger);

        messagingTemplate.convertAndSend("/topic/passengers", passengerCreated);

        return ResponseEntity.ok(passengerCreated);

    }

    @SendTo("/topic/passengers")
    public Passenger broadcastMessage(@Payload Passenger passenger) {
        return passenger;
    }

    @GetMapping("/get-by-id/{idPassenger}")
    public ResponseEntity<Passenger> createPassenger(@PathVariable Integer idPassenger) {

        var passengerCreated = passengerService.getById(idPassenger);

        return ResponseEntity.ok(passengerCreated);

    }

    @GetMapping("/get-all-passengers")
    public ResponseEntity<List<Passenger>> getAllPassengers() {

        var bookings = passengerService.getAllPassengers();

        return ResponseEntity.ok(bookings);

    }


    @PutMapping("/update")
    public ResponseEntity<Passenger> updatePassenger(@RequestBody Passenger passenger) {

        var passengerCreated = passengerService.update(passenger);

        return ResponseEntity.ok(passengerCreated);

    }

    @GetMapping("/filter-by-name/{name}")
    public ResponseEntity<List<Passenger>> filterByName(@PathVariable String name) {
        var passengerList = passengerService.findByName(name);

        return ResponseEntity.ok(passengerList);
    }


}
