package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Accommodation;
import com.easytrip.easytrip.payload.response.MessageResponse;
import com.easytrip.easytrip.services.impl.AccommodationServiceImpl;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/test/accomodations")
public class AccommodationController implements Controller<Accommodation> {


    @Autowired
    private AccommodationServiceImpl accommodationService;

    private MessageResponse messageResponse;

    @GetMapping("/search/location/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Accommodation>> findByLocation(Pageable pageable, String searchText) {
        try {
            return new ResponseEntity<>(accommodationService.findByLocation(pageable, searchText), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error Location Search");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/name/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Accommodation>> findByName(Pageable pageable, String searchText) {
        try {
            return new ResponseEntity<>(accommodationService.findByName(pageable, searchText), HttpStatus.OK);
        }catch (Exception e){
        System.out.println("Error Name Search");
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
    }


    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Accommodation>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {

        try {
        return new ResponseEntity<>(accommodationService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error getting Accommodation pages");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Accommodation> findById(Long id) {
        try{
        return new ResponseEntity<>(accommodationService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error getting Accommodation by id");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    public ResponseEntity<Accommodation> save(Accommodation accommodation) {
        try {
            return new ResponseEntity<>(accommodationService.saveOrUpdate(accommodation), HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Error saving Accommodations");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("asRole('ROLE_ADMIN')")
    public ResponseEntity<Accommodation> update(Accommodation accommodation) {
        try {
        return new ResponseEntity<>(accommodationService.saveOrUpdate(accommodation), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error updating Accommodations");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {

        try{
        return new ResponseEntity<>(accommodationService.deleteById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error deleting Accommodation");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}