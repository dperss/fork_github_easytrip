package com.easytrip.easytrip.services.impl;


import com.easytrip.easytrip.models.Role;
import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.repository.RoleRepository;
import com.easytrip.easytrip.repository.UserRepository;
import com.easytrip.easytrip.security.services.UserDetailsImpl;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements Services<User> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public Page<User> loadUserByEmail(Pageable pageable, String searchText) {
        return userRepository.findByEmail(pageable,searchText);
    }


    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {


        return userRepository.findById(id).get();
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            userRepository.deleteById(id);
            jsonObject.put("message", "User deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }



    /*public Role postRole(Long userid,
                          Role role) {
        return userRepository.findById(userid).map(post -> {
            User.setRoles(role);
            return roleRepository.save(role);
        }).orElseThrow(() -> new ResourceNotFoundException("User id " + userid + " not found"));
    }*/
}
