package com.easytrip.easytrip.resource.impl;

import com.easytrip.easytrip.domain.Travel;
import com.easytrip.easytrip.resource.Resource;
import com.easytrip.easytrip.service.IService;
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

/*
@RestController
@RequestMapping("/travels")
@CrossOrigin(origins="http://localhost:3000")
public class TravelResourceImpl implements Resource<Travel> {

    @Autowired
    private IService<Travel> travelIService;

    @Override
    public ResponseEntity<Page<Travel>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(travelIService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Travel>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(travelIService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Travel> findById(Long id) {
        return new ResponseEntity<>(travelIService.findById(id), HttpStatus.OK);

    }


    @Override
    public ResponseEntity<Travel> save(Travel travel) {
        return new ResponseEntity<>(travelIService.saveOrUpdate(travel), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Travel> update(Travel travel) {
        return new ResponseEntity<>(travelIService.saveOrUpdate(travel), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(travelIService.deleteById(id), HttpStatus.OK);
    }

}
*/