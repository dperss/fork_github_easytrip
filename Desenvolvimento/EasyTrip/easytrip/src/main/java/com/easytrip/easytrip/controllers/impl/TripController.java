package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Trip;
import com.easytrip.easytrip.services.impl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/trips")
public class TripController implements Controller<Trip> {


    @Autowired
    private TripServiceImpl tripService;



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<Trip>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {



        return new ResponseEntity<>(tripService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Trip> findById(Long id) {
        try{
            return new ResponseEntity<>(tripService.findById(id), HttpStatus.OK);}
        catch (Exception e){

            System.out.println("Trip does´t exist");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }


    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Trip> save(Trip user) {
        System.out.println("Trip created");
        return new ResponseEntity<>(tripService.saveOrUpdate(user), HttpStatus.CREATED);
    }



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Trip> update(Trip trip) {
        System.out.println("Trip Updated");
        return new ResponseEntity<>(tripService.saveOrUpdate(trip), HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {
        System.out.println("Trip deleted ID:" + id);
        return new ResponseEntity<>(tripService.deleteById(id), HttpStatus.OK);
    }
}
