package com.easytrip.easytrip.service.impl;

import com.easytrip.easytrip.domain.User;
import com.easytrip.easytrip.repository.UserRepository;
import com.easytrip.easytrip.service.IService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable, String searchText) {
        return userRepository.findAllPersons(pageable, searchText);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
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