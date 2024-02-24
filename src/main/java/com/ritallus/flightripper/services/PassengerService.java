package com.ritallus.flightripper.services;

import com.ritallus.flightripper.entities.Booking;
import com.ritallus.flightripper.entities.Passenger;
import com.ritallus.flightripper.repositories.PassengerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class PassengerService {

    private PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }


    public Passenger save(Passenger passenger){ // DTO = Data Transfer Object

        var passangerCreated = passengerRepository.save(passenger);

        return passangerCreated;
    }

    public Passenger getById(Integer idPassenger) {

        if (Objects.isNull(idPassenger)){
            throw new RuntimeException("No puede ser nulo el id");
        }
        return passengerRepository.findById(idPassenger).orElseThrow(()-> new RuntimeException("Data not found"));
    }

    public List<Passenger> getAllPassengers(){
        var passengers = passengerRepository.findAll();
        return passengers;
    }

    public Passenger update(Passenger passenger) {
        if (Objects.isNull(passenger.getId())){
            throw new RuntimeException("No puede ser nulo el id"); //ESTO LO PUEDEN PERSONALIZAR control advice
        }

        var passangerFound = getById(passenger.getId());
        passangerFound.setDocument(passenger.getDocument());
        passangerFound.setFullName(passenger.getFullName());

        return passangerFound;
    }

    public void delete(Integer idPassenger) {
        if(Objects.nonNull(idPassenger)) {
            Optional<Passenger> studentOptional = passengerRepository.findById(idPassenger);
            if (!studentOptional.isPresent()) {
                throw new RuntimeException("data not found");
            }
        }

        passengerRepository.deleteById(idPassenger);
    }

    public List<Passenger> findByName(String name) {
        var passenger = passengerRepository.findByFullNameStartingWithVersion3(name); //CAMBIÉ aquí las otras dos formas

        return passenger;
    }


}
