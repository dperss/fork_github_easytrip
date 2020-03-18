package com.easytrip.easytrip.controller;


import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Trip;
import com.easytrip.easytrip.repository.PersonRepository;
import com.easytrip.easytrip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TripController {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private PersonRepository personRepository;

    //GET
    @GetMapping("/persons/{personId}/trips")
    public List<Trip> getTripsByQuestionId(@PathVariable Long personId) {
        return tripRepository.findByPersonId(personId);
    }

    //POST
    @PostMapping("/persons/{personId}/trips")
    public Trip addTrip(@PathVariable Long personId,
                            @Valid @RequestBody Trip trips) {
        return personRepository.findById(personId)
                .map(person -> {
                    trips.setPerson(person);
                    return tripRepository.save(trips);
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }

    @PutMapping("/persons/{personId}/trips/{tripId}")
    public Trip updateTrip(@PathVariable Long personId,
                               @PathVariable Long tripId,
                               @Valid @RequestBody Trip tripRequest) {
        if(!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Person not found with id " + personId);
        }

        return tripRepository.findById(tripId)
                .map(trip -> {
                    trip.setDestiny(tripRequest.getDestiny());
                    trip.setOrigin(tripRequest.getOrigin());
                    trip.setDestiny(tripRequest.getDestiny());
                    trip.setOrigin_data(tripRequest.getOrigin_data());
                    trip.setDestiny_data(tripRequest.getDestiny_data());
                    trip.setAccommodation(tripRequest.getAccommodation());
                    trip.setTransportation(tripRequest.getTransportation());
                    return tripRepository.save(trip);
                }).orElseThrow(() -> new ResourceNotFoundException("Trip not found with id " + tripId));
    }

    @DeleteMapping("/persons/{personId}/trips/{tripId}")
    public ResponseEntity<?> deleteAnswer(@PathVariable Long personId,
                                          @PathVariable Long tripId) {
        if(!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Person not found with id " + personId);
        }

        return tripRepository.findById(tripId)
                .map(trip -> {
                    tripRepository.delete(trip);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Trip not found with id " + tripId));

    }
}
