package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Accommodation;
import com.easytrip.easytrip.models.Comment;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.services.impl.AccommodationServiceImpl;
import com.easytrip.easytrip.services.impl.Point_of_InterestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/test/accomodations")
public class AccommodationController implements Controller<Accommodation> {


    @Autowired
    private AccommodationServiceImpl accommodationService;



    @Override
    public ResponseEntity<Page<Accommodation>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
            return new ResponseEntity<>(accommodationService.findAll(
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
    public ResponseEntity<Accommodation> findById(Long id) {

        return new ResponseEntity<>(accommodationService.findById(id), HttpStatus.OK);


    }



    @Override
    public ResponseEntity<Accommodation> save(Accommodation accommodation) {
        System.out.println("Trip created");
        return new ResponseEntity<>(accommodationService.saveOrUpdate(accommodation), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Accommodation> update(Accommodation accommodation) {
        System.out.println("Accommodation Updated");
        return new ResponseEntity<>(accommodationService.saveOrUpdate(accommodation), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Accommodation deleted ID:" + id);
        return new ResponseEntity<>(accommodationService.deleteById(id), HttpStatus.OK);
    }

}