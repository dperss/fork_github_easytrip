package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Comment;
import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.services.impl.CommentServiceImpl;
import com.easytrip.easytrip.services.impl.ItineraryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/test/itinerarys")
public class ItineraryController implements Controller<Itinerary> {


    @Autowired
    private ItineraryServiceImpl itineraryService;



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<Itinerary>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
            return new ResponseEntity<>(itineraryService.findAll(
                    PageRequest.of(
                            pageNumber, pageSize,
                            sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                    )
            ), HttpStatus.OK);}catch (Exception e){
            System.out.println("PError");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Itinerary> findById(Long id) {

        return new ResponseEntity<>(itineraryService.findById(id), HttpStatus.OK);


    }



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Itinerary> save(Itinerary itinerary) {
        System.out.println("Itinerary created");
        return new ResponseEntity<>(itineraryService.saveOrUpdate(itinerary), HttpStatus.CREATED);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Itinerary> update(Itinerary itinerary) {
        System.out.println("Itinerary Updated");
        return new ResponseEntity<>(itineraryService.saveOrUpdate(itinerary), HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Itinerary deleted ID:" + id);
        return new ResponseEntity<>(itineraryService.deleteById(id), HttpStatus.OK);
    }

}