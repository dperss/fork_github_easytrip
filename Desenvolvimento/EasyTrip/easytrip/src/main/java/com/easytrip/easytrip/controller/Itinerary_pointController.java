package com.easytrip.easytrip.controller;

import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Itinerary_point;
import com.easytrip.easytrip.repository.ItineraryRepository;
import com.easytrip.easytrip.repository.Itinerary_pointRepository;
import com.easytrip.easytrip.repository.Point_of_interestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Itinerary_pointController{


    @Autowired
    private ItineraryRepository itineraryRepository;

    @Autowired
    private Point_of_interestRepository point_of_interestRepository;

    @Autowired
    private Itinerary_pointRepository itinerary_pointRepository;


    //GET
    @GetMapping("/itinerary/{itineraryId}/itinerary_points")
    public List<Itinerary_point> getItineraryByItinerary_pointsId(@PathVariable Long itineraryId) {
        return itinerary_pointRepository.findByItineraryId(itineraryId);
    }
    //GET
    @GetMapping("/point_of_interest/{point_of_interestId}/itinerary_points")
    public List<Itinerary_point> getPoint_of_interestsByItinerary_pointsId(@PathVariable Long point_of_interestId) {
        return itinerary_pointRepository.findByPoint_of_interestId(point_of_interestId);
    }

    //POST
    @PostMapping("/itinerary/{itineraryId}/itinerary_points")
    public Itinerary_point addItinerary(@PathVariable Long itineraryId,
                                  @Valid @RequestBody Itinerary_point itinerary_points) {
        return itineraryRepository.findById(itineraryId)
                .map(itinerary -> {
                    itinerary_points.setItinerary(itinerary);
                    return itinerary_pointRepository.save(itinerary_points);
                }).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
    }
    //POST
    @PostMapping("/point_of_interest/{point_of_interestId}/itinerary_points")
    public Itinerary_point addPoint_of_interest(@PathVariable Long point_of_interestId,
                                        @Valid @RequestBody Itinerary_point itinerary_points) {
        return point_of_interestRepository.findById(point_of_interestId)
                .map(point_of_interest -> {
                    itinerary_points.setPoint_of_interest(point_of_interest);
                    return itinerary_pointRepository.save(itinerary_points);
                }).orElseThrow(() -> new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId));
    }



    @PutMapping("/point_of_interest/{point_of_interestId}/itinerary/{itineraryId}/itinerary_points/{itinerary_pointId}")
    public Itinerary_point updateItinerary_point(@PathVariable Long point_of_interestId,
                                     @PathVariable Long itineraryId,
                                     @PathVariable Long itinerary_pointId,
                                     @Valid @RequestBody Itinerary_point itinerary_pointRequest) {
        if(!itineraryRepository.existsById(itineraryId)) {
            throw new ResourceNotFoundException("Itinerary not found with id " + itineraryId);
        }
        if(!point_of_interestRepository.existsById(point_of_interestId)) {
            throw new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId);
        }

        return itinerary_pointRepository.findById(itinerary_pointId)
                .map(itinerary_point -> {
                    itinerary_point.setItinerary(itinerary_pointRequest.getItinerary());
                    itinerary_point.setPoint_of_interest(itinerary_pointRequest.getPoint_of_interest());
                    return itinerary_pointRepository.save(itinerary_point);
                }).orElseThrow(() -> new ResourceNotFoundException("Itinerary point not found with id " + itinerary_pointId));
    }


    @DeleteMapping("/point_of_interest/{point_of_interestId}/itinerary/{itineraryId}/itinerary_points/{itinerary_pointId}")
    public ResponseEntity<?> deleteItinerary_point(@PathVariable Long point_of_interestId,
                                             @PathVariable Long itineraryId,
                                             @PathVariable Long itinerary_pointId) {
        if(!itineraryRepository.existsById(itineraryId)) {
            throw new ResourceNotFoundException("Itinerary not found with id " + itineraryId);
        }
        if(!point_of_interestRepository.existsById(point_of_interestId)) {
            throw new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId);
        }

        return itinerary_pointRepository.findById(itinerary_pointId)
                .map(itinerary_point -> {
                    itinerary_pointRepository.delete(itinerary_point);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Itinerary point not found with id " + itinerary_pointId));

    }
}
