package com.easytrip.easytrip.controller;


import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Point_of_interest;
import com.easytrip.easytrip.repository.Point_of_interestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Point_of_interestController {

    @Autowired
    private Point_of_interestRepository point_of_interestRepository;

    //GET
    @GetMapping("/point_of_interests")
    public Page<Point_of_interest> getPoint_of_interests(Pageable pageable) {
        return point_of_interestRepository.findAll(pageable);
    }

    //POST
    @PostMapping("/point_of_interest")
    public Point_of_interest createPoint_of_interests(@Valid @RequestBody Point_of_interest point_of_interest) {
        return point_of_interestRepository.save(point_of_interest);
    }

    //UPDATE
    @PutMapping("/point_of_interests/{point_of_interestId}")
    public Point_of_interest updatePoint_of_interests(@PathVariable Long point_of_interestId,
                                @Valid @RequestBody Point_of_interest point_of_interestRequest) {
        return point_of_interestRepository.findById(point_of_interestId)
                .map(point_of_interests -> {
                    point_of_interests.setName(point_of_interestRequest.getName());
                    point_of_interests.setGPS(point_of_interestRequest.getGPS());
                    point_of_interests.setClassification(point_of_interestRequest.getClassification());
                    point_of_interests.setDescription(point_of_interestRequest.getDescription());
                    point_of_interests.setType_of_point(point_of_interestRequest.getType_of_point());
                    point_of_interests.setDescription(point_of_interestRequest.getDescription());
                    return point_of_interestRepository.save(point_of_interests);
                }).orElseThrow(() -> new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId));
    }


    //DELETE
    @DeleteMapping("/point_of_interestss/{point_of_interestId}")
    public ResponseEntity<?> deletePoint_of_interestss(@PathVariable Long point_of_interestId) {
        return point_of_interestRepository.findById(point_of_interestId)
                .map(point_of_interest -> {
                    point_of_interestRepository.delete(point_of_interest);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId));
    }
}
