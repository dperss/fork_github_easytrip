package com.easytrip.easytrip.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



public interface Controller<T> {

    @GetMapping
    ResponseEntity<Page<T>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir);

    @GetMapping("{id}")
    ResponseEntity<T> findById(@PathVariable Long id);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<T> save(@RequestBody T t);

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<T> update(@RequestBody T t);

    @DeleteMapping("{id}")
    ResponseEntity<String> deleteById(@PathVariable Long id);
}
