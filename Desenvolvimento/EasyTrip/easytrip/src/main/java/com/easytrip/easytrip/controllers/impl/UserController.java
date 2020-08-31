package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.models.Role;
import com.easytrip.easytrip.models.Trip;
import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.repository.UserRepository;
import com.easytrip.easytrip.services.Services;
import com.easytrip.easytrip.services.impl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/test/users")
public class UserController implements Controller<User> {

    @Autowired
    private UserServiceImpl userService;



    /*@Autowired
    private Services<Role> roleServices;

    @Autowired
    private Services<Point_of_Interest> point_of_interestServices;

    @Autowired
    private Services<Trip> tripServices;*/

    @ApiOperation(value = "Finds contact bye Email"
    )
    @GetMapping("/search/email/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<User>> findByEmail(Pageable pageable, String searchText) {
        return new ResponseEntity<>(userService.findByEmail(pageable, searchText), HttpStatus.OK);
    }

    @ApiOperation(value = "Finds contact bye Username"
    )
    @GetMapping("/search/username/{searchText}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<User>> findByUsername(Pageable pageable, String searchText) {
        return new ResponseEntity<>(userService.findByUsername(pageable, searchText), HttpStatus.OK);
    }



    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<Page<User>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(userService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN') or hasRole('ROLE_USER_BLOCKED')")
    public ResponseEntity<User> findById(Long id) {
        try{
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);}
        catch (Exception e){

            System.out.println("User does´t exist");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

    }

   /* @PostMapping("/{userid}/roles")
    public Role postRole(@PathVariable (value = "userid") Long userid,
                                 @Valid @RequestBody Role role) {
        return userRepository.findById(userid).map(post -> {
            User.setRoles(role);
            return roleServices.save(role);
        }).orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found"));
    }*/



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
