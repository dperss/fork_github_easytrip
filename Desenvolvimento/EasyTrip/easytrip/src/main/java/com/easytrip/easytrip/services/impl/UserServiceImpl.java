package com.easytrip.easytrip.services.impl;


import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements Services<User> {
    @Override
    public Page<User> findAll(Pageable pageable, String searchText) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User saveOrUpdate(User user) {
        return null;
    }

    @Override
    public String deleteById(Long id) {
        return null;
    }
}
