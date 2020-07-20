package com.easytrip.easytrip.resource.impl;

import com.easytrip.easytrip.domain.Person;
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


@RestController
@RequestMapping("/persons")
@CrossOrigin(origins="http://localhost:3000")
public class PersonResourceImpl implements Resource<Person> {

    @Autowired
    private IService<Person> personService;

    @Override
    public ResponseEntity<Page<Person>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(personService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Person>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(personService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Person> findById(Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Person> save(Person person) {
        return new ResponseEntity<>(personService.saveOrUpdate(person), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Person> update(Person person) {
        return new ResponseEntity<>(personService.saveOrUpdate(person), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(personService.deleteById(id), HttpStatus.OK);
    }

}
