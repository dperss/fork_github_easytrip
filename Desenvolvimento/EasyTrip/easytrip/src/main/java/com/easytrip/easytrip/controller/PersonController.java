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

    //GET
    @GetMapping("/persons")
    public Page<Person> getPersons(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    //POST
    @PostMapping("/persons")
    public Person createPersons(@Valid @RequestBody Person persons) {
        return personRepository.save(persons);
    }

    //PUT
    @PutMapping("/persons/{personId}")
    public Person updatePersons(@PathVariable Long personId,
                                   @Valid @RequestBody Person personRequest) {
        return personRepository.findById(personId)
                .map(person -> {
                    person.setEmail(personRequest.getEmail());
                    person.setPassword(personRequest.getPassword());
                    person.setNome(personRequest.getNome());
                    person.setDescription(personRequest.getDescription());
                    return personRepository.save(person);
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }


    //DELETE
    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<?> deletePerson(@PathVariable Long personId) {
        return personRepository.findById(personId)
                .map(person -> {
                    personRepository.delete(person);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }
}
