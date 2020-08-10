package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/trips")
public class TripController implements Controller<Trip> {

    @Override
    public ResponseEntity<Page<Trip>> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Trip>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ResponseEntity<Trip> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Trip> save(Trip trip) {
        return null;
    }

    @Override
    public ResponseEntity<Trip> update(Trip trip) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return null;
    }
}
