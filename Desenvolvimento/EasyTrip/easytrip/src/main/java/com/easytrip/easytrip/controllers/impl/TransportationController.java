package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Transportation;
import com.easytrip.easytrip.models.Trip;
import com.easytrip.easytrip.services.impl.TransportationServiceImpl;
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
@RequestMapping("/api/test/transportations")
public class TransportationController implements Controller<Transportation> {


    @Autowired
    private TransportationServiceImpl transportationService;



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Transportation>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
        return new ResponseEntity<>(transportationService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Transportation> findById(Long id) {
        try{
            return new ResponseEntity<>(transportationService.findById(id), HttpStatus.OK);}
        catch (Exception e){

            System.out.println("Transportation does´t exist");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }


    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Transportation> save(Transportation transportation) {
        try{
        return new ResponseEntity<>(transportationService.saveOrUpdate(transportation), HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Transportation> update(Transportation transportation) {
        try{
        return new ResponseEntity<>(transportationService.saveOrUpdate(transportation), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {
        try{
        return new ResponseEntity<>(transportationService.deleteById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}