package com.easytrip.easytrip.controller;


import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Itinerary;
import com.easytrip.easytrip.repository.ItineraryRepository;
import com.easytrip.easytrip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ItineraryController {

    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private TripRepository tripRepository;


    //GET
    @GetMapping("/trips/{tripId}/itinerarys")
    public List<Itinerary> getTripsByItineraryId(@PathVariable Long tripId) {
        return itineraryRepository.findByTripId(tripId);
    }

    //POST
    @PostMapping("/trips/{tripId}/itinerarys")
    public Itinerary addItinerary(@PathVariable Long tripId,
                        @Valid @RequestBody Itinerary itinerarys) {
        return tripRepository.findById(tripId)
                .map(trip -> {
                    itinerarys.setTrip(trip);
                    return itineraryRepository.save(itinerarys);
                }).orElseThrow(() -> new ResourceNotFoundException("Trip not found with id " + tripId));
    }

    @PutMapping("/trips/{tripId}/itinerarys/{itineraryId}")
    public Itinerary updateItinerary(@PathVariable Long tripId,
                           @PathVariable Long itineraryId,
                           @Valid @RequestBody Itinerary itineraryRequest) {
        if(!tripRepository.existsById(tripId)) {
            throw new ResourceNotFoundException("Trip not found with id " + tripId);
        }

        return itineraryRepository.findById(itineraryId)
                .map(itinerary -> {
                    itinerary.setClassification(itineraryRequest.getClassification());
                    return itineraryRepository.save(itinerary);
                }).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
    }

    @DeleteMapping("/trips/{tripId}/itinerary/{itineraryId}")
    public ResponseEntity<?> deleteItinerary(@PathVariable Long tripId,
                                          @PathVariable Long itineraryId) {
        if(!tripRepository.existsById(tripId)) {
            throw new ResourceNotFoundException("Trip not found with id " + tripId);
        }

        return itineraryRepository.findById(itineraryId)
                .map(itinerary -> {
                    itineraryRepository.delete(itinerary);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));

    }
}
