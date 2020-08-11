package com.easytrip.easytrip.controllers.impl;


import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.services.impl.Point_of_InterestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/point_of_interests")
public class Point_of_InterestController implements Controller<Point_of_Interest> {


    @Autowired
    private Point_of_InterestServiceImpl point_of_interestService;



    @Override
    public ResponseEntity<Page<Point_of_Interest>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
        return new ResponseEntity<>(point_of_interestService.findAll(
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
    public ResponseEntity<Point_of_Interest> findById(Long id) {

            return new ResponseEntity<>(point_of_interestService.findById(id), HttpStatus.OK);


    }



    @Override
    public ResponseEntity<Point_of_Interest> save(Point_of_Interest point_of_interest) {
        System.out.println("Trip created");
        return new ResponseEntity<>(point_of_interestService.saveOrUpdate(point_of_interest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Point_of_Interest> update(Point_of_Interest point_of_interest) {
        System.out.println("Trip Updated");
        return new ResponseEntity<>(point_of_interestService.saveOrUpdate(point_of_interest), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Trip deleted ID:" + id);
        return new ResponseEntity<>(point_of_interestService.deleteById(id), HttpStatus.OK);
    }

}
