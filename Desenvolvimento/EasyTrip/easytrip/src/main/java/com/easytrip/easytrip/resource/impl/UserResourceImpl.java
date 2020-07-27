package com.easytrip.easytrip.resource.impl;

import com.easytrip.easytrip.domain.User;
import com.easytrip.easytrip.resource.Resource;
import com.easytrip.easytrip.service.impl.UserServiceImpl;
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
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserResourceImpl implements Resource<User> {

    @Autowired
    private UserServiceImpl userService;


    @Override
    public ResponseEntity<Page<User>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(userService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<User>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(userService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        try{
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);}
        catch (Exception e){
            System.out.println("User does´t exist");
            return null;
        }

    }

    @Override
    public ResponseEntity<User> findByEmail(String email) {
        try{
        return new ResponseEntity<>(userService.findByEmail(email), HttpStatus.OK);}
        catch (Exception e){
            System.out.println("User does´t exist");
            return null;
        }

    }


    @Override
    public ResponseEntity<User> save(User user) {
        System.out.println("updateUser");
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> update(User user) {
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

}
