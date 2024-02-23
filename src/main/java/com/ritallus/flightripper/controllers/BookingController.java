package com.ritallus.flightripper.controllers;

import com.ritallus.flightripper.entities.Booking;
import com.ritallus.flightripper.services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/get-all-bookings")
    public ResponseEntity<List<Booking>> getAllBookings() {

        var bookings = bookingService.getAllBookings();

        return ResponseEntity.ok(bookings);

    }
}
