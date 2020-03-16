package com.easytrip.easytrip.controller;


import com.easytrip.easytrip.exception.ResourceNotFoundException;
import com.easytrip.easytrip.model.Person;
import com.easytrip.easytrip.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public Page<Person> getPersons(Pageable pageable) {
        return personRepository.findAll(pageable);
    }


    @PostMapping("/persons")
    public Person createPersons(@Valid @RequestBody Person persons) {
        return personRepository.save(persons);
    }

    @PutMapping("/persons/{personId}")
    public Person updatePersons(@PathVariable Long personId,
                                   @Valid @RequestBody Person personRequest) {
        return personRepository.findById(personId)
                .map(question -> {
                    question.setEmail(personRequest.getEmail());
                    question.setPassword(personRequest.getPassword());
                    return personRepository.save(question);
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }


    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable Long personId) {
        return personRepository.findById(personId)
                .map(person -> {
                    personRepository.delete(person);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }
}
