package com.easytrip.easytrip.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public interface Resource<T> {

	@GetMapping("/search/{searchText}")
    ResponseEntity<Page<T>> findAll(Pageable pageable, @PathVariable String searchText);

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    ResponseEntity<Page<T>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
	
	@GetMapping("{id}")
    ResponseEntity<T> findById(@PathVariable Long id);

    @GetMapping("/email/{email}")
    ResponseEntity<T> findByEmail(@PathVariable String email);
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<T> save(@RequestBody T t);
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<T> update(@RequestBody T t);
	
	@DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('user:write')")
    ResponseEntity<String> deleteById(@PathVariable Long id);
}
