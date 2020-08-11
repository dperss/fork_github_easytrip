package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.models.Point_of_Interest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itinerarys")
public class ItineraryController implements Controller<Itinerary> {


    public ResponseEntity<Page<Itinerary>> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Itinerary>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ResponseEntity<Itinerary> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Itinerary> save(Itinerary itinerary) {
        return null;
    }

    @Override
    public ResponseEntity<Itinerary> update(Itinerary itinerary) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return null;
    }
}
