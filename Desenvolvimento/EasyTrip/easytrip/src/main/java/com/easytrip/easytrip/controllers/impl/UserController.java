package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.repository.RoleRepository;
import com.easytrip.easytrip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@RestController
//@RequestMapping("/users")
public class UserController implements Controller<User> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;


    @Override
    public ResponseEntity<Page<User>> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public ResponseEntity<Page<User>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public ResponseEntity<User> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<User> save(User user) {
        return null;
    }

    @Override
    public ResponseEntity<User> update(User user) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return null;
    }
}
