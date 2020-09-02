package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Trip;
import com.easytrip.easytrip.services.impl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/trips")
public class TripController implements Controller<Trip> {


    @Autowired
    private TripServiceImpl tripService;


    @GetMapping("/search/origin/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Trip>> findByOrigin(Pageable pageable, String searchText) {
        try{
        return new ResponseEntity<>(tripService.findByOrigin(pageable, searchText), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error finding Trip bye Origin");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/destiny/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Trip>> findByDestiny(Pageable pageable, String searchText) {
        try{
        return new ResponseEntity<>(tripService.findByDestiny(pageable, searchText), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error finding Trip bye Destiny");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Trip>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {

        try{
        return new ResponseEntity<>(tripService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error getting Trip pages");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
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
        try{
        return new ResponseEntity<>(tripService.saveOrUpdate(user), HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Error saving Trip");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Trip> update(Trip trip) {
        try{
        return new ResponseEntity<>(tripService.saveOrUpdate(trip), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error updating Trip");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {
        try{
        return new ResponseEntity<>(tripService.deleteById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error deleting Trip");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
