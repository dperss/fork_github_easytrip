package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.models.Role;
import com.easytrip.easytrip.models.Transportation;
import com.easytrip.easytrip.repository.Point_of_InterestRepository;
import com.easytrip.easytrip.repository.RoleRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RoleServiceImpl implements Services<Role> {

    @Autowired
    RoleRepository roleRepository;


    @Override
    public Page findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role saveOrUpdate(Role role) {

        return roleRepository.save(role);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            roleRepository.deleteById(id);
            jsonObject.put("message", "Role deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
