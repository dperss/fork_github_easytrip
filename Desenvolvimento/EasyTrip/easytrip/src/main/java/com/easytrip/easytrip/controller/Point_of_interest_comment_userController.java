package com.easytrip.easytrip.controller;

import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Itinerary_point;
import com.easytrip.easytrip.model.Point_of_interest_comment_user;
import com.easytrip.easytrip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Point_of_interest_comment_userController{


    @Autowired
    private Point_of_interest_comment_userRepository point_of_interest_comment_userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private Point_of_interestRepository point_of_interestRepository;



    //GET
    @GetMapping("/person/{personId}/point_of_interest_comment_users")
    public List<Point_of_interest_comment_user> getPersonByPersonId(@PathVariable Long personId) {
        return point_of_interest_comment_userRepository.findByPersonId(personId);
    }
    //GET
    @GetMapping("/point_of_interest/{point_of_interestId}/point_of_interest_comment_users")
    public List<Point_of_interest_comment_user> getPoint_of_interestsByItinerary_pointsId(@PathVariable Long point_of_interestId) {
        return point_of_interest_comment_userRepository.findByPoint_of_interestId(point_of_interestId);
    }

    //POST
    @PostMapping("/person/{personId}/point_of_interest_comment_users")
    public Point_of_interest_comment_user addPerson(@PathVariable Long personId,
                                        @Valid @RequestBody Point_of_interest_comment_user point_of_interest_comment_users) {
        return personRepository.findById(personId)
                .map(person -> {
                    point_of_interest_comment_users.setPerson(person);
                    return point_of_interest_comment_userRepository.save(point_of_interest_comment_users);
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }
    //POST
    @PostMapping("/point_of_interest/{point_of_interestId}/point_of_interest_comment_users")
    public Point_of_interest_comment_user addPoint_of_interest(@PathVariable Long point_of_interestId,
                                                @Valid @RequestBody Point_of_interest_comment_user point_of_interest_comment_users) {
        return point_of_interestRepository.findById(point_of_interestId)
                .map(point_of_interest -> {
                    point_of_interest_comment_users.setPoint_of_interest(point_of_interest);
                    return point_of_interest_comment_userRepository.save(point_of_interest_comment_users);
                }).orElseThrow(() -> new ResourceNotFoundException("Point of interest of interest not found with id " + point_of_interestId));
    }



    @PutMapping("/point_of_interest/{point_of_interestId}/person/{personId}/point_of_interest_comment_users/{point_of_interest_comment_usersId}")
    public Point_of_interest_comment_user updatePoint_of_interest_comment_user(@PathVariable Long point_of_interestId,
                                                 @PathVariable Long personId,
                                                 @PathVariable Long point_of_interest_comment_usersId,
                                                 @Valid @RequestBody Point_of_interest_comment_user point_of_interest_comment_usersRequest) {
        if(!point_of_interestRepository.existsById(point_of_interestId)) {
            throw new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId);
        }
        if(!point_of_interestRepository.existsById(point_of_interest_comment_usersId)) {
            throw new ResourceNotFoundException("Person of interest comment usersId not found with id " + personId);
        }

        return point_of_interest_comment_userRepository.findById(point_of_interest_comment_usersId)
                .map(point_of_interest_comment_user -> {
                    point_of_interest_comment_user.setPerson(point_of_interest_comment_usersRequest.getPerson());
                    point_of_interest_comment_user.setPoint_of_interest(point_of_interest_comment_usersRequest.getPoint_of_interest());
                    return point_of_interest_comment_userRepository.save(point_of_interest_comment_user);
                }).orElseThrow(() -> new ResourceNotFoundException("Point of interest comment user point not found with id " + point_of_interest_comment_usersId));
    }


    @DeleteMapping("/point_of_interest/{point_of_interestId}/person/{personId}/point_of_interest_comment_users/{point_of_interest_comment_usersId}")
    public ResponseEntity<?> deleteItinerary_point(@PathVariable Long point_of_interestId,
                                                   @PathVariable Long personId,
                                                   @PathVariable Long point_of_interest_comment_usersId) {
        if(!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Person not found with id " + personId);
        }
        if(!point_of_interestRepository.existsById(point_of_interestId)) {
            throw new ResourceNotFoundException("Point of interest not found with id " + point_of_interestId);
        }

        return point_of_interest_comment_userRepository.findById(point_of_interest_comment_usersId)
                .map(point_of_interest_comment_user -> {
                    point_of_interest_comment_userRepository.delete(point_of_interest_comment_user);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Point of interest comment user point not found with id " + point_of_interest_comment_usersId));

    }
}
