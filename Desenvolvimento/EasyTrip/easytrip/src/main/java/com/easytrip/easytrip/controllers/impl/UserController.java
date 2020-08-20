package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.services.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
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


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test/users")
public class UserController implements Controller<User> {

    @Autowired
    private UserServiceImpl userService;


    @ApiOperation(value = "Finds contact bye email",
            notes = "tesddsdsd"
            //response = "Page<User>"
    )
    @GetMapping("/search/{searchText}")
    public ResponseEntity<Page<User>> findByEmail(Pageable pageable, String searchText) {
        return new ResponseEntity<>(userService.loadUserByEmail(pageable, searchText), HttpStatus.OK);
    }



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<Page<User>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {



        return new ResponseEntity<>(userService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> findById(Long id) {
        try{
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);}
        catch (Exception e){

            System.out.println("User does´t exist");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> save(User user) {
        System.out.println("User created");
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.CREATED);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<User> update(User user) {
        System.out.println("User Updated");
        return new ResponseEntity<>(userService.saveOrUpdate(user), HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteById(Long id) {
        System.out.println("User deleted ID:" + id);
        return new ResponseEntity<>(userService.deleteById(id), HttpStatus.OK);
    }

}
