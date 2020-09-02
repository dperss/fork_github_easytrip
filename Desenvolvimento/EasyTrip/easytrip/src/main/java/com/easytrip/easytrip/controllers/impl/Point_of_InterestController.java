package com.easytrip.easytrip.controllers.impl;


import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.services.impl.Point_of_InterestServiceImpl;
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
@RequestMapping("/api/test/point_of_interests")
public class Point_of_InterestController implements Controller<Point_of_Interest> {


    @Autowired
    private Point_of_InterestServiceImpl point_of_interestService;


    @GetMapping("/search/name/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Point_of_Interest>> findByName(Pageable pageable, String searchText) {
        try{
        return new ResponseEntity<>(point_of_interestService.findByName(pageable, searchText), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/search/location/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Point_of_Interest>> findByLocation(Pageable pageable, String searchText) {
        try{
        return new ResponseEntity<>(point_of_interestService.findByLocation(pageable, searchText), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<Point_of_Interest>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try {
            return new ResponseEntity<>(point_of_interestService.findAll(
                    PageRequest.of(
                            pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);}catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Point_of_Interest> findById(Long id) {
            try{
            return new ResponseEntity<>(point_of_interestService.findById(id), HttpStatus.OK);
            }catch (Exception e){
                System.out.println("Error");
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }


    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Point_of_Interest> save(Point_of_Interest point_of_interest) {
        try{
        return new ResponseEntity<>(point_of_interestService.saveOrUpdate(point_of_interest), HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Point_of_Interest> update(Point_of_Interest point_of_interest) {
        try{
        return new ResponseEntity<>(point_of_interestService.saveOrUpdate(point_of_interest), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {
        try{
        return new ResponseEntity<>(point_of_interestService.deleteById(id), HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
