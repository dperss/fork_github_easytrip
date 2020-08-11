package com.easytrip.easytrip.services.impl;


import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.repository.UserRepository;
import com.easytrip.easytrip.security.services.UserDetailsImpl;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements Services<User> {

    @Autowired
    private UserRepository userRepository;


    public Page<User> loadUserByEmail(Pageable pageable, String searchText) {
        return userRepository.findByEmail(pageable,searchText);
    }


    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;// userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {

        userRepository.findById(id);
        return null;
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

}
