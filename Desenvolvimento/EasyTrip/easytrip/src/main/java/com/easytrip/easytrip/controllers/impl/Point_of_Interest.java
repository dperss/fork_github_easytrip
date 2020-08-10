package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/point_of_interests")
public class Point_of_Interest implements Controller<Point_of_Interest> {


    @Override
    public ResponseEntity<Page<Point_of_Interest>> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Point_of_Interest>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ResponseEntity<Point_of_Interest> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Point_of_Interest> save(Point_of_Interest point_of_interest) {
        return null;
    }

    @Override
    public ResponseEntity<Point_of_Interest> update(Point_of_Interest point_of_interest) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return null;
    }
}
