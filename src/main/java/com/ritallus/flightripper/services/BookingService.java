package com.ritallus.flightripper.services;

import com.ritallus.flightripper.entities.Booking;
import com.ritallus.flightripper.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings(){
        var bookings = bookingRepository.findAll();

        for (Booking booking: bookings ) {
            System.out.println("booking: "+ booking);
        }

        return bookings;
    }


}
