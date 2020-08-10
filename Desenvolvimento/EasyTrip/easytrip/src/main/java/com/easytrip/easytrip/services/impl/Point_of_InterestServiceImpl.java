package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.models.Trip;
import com.easytrip.easytrip.repository.Point_of_InterestRepository;
import com.easytrip.easytrip.repository.TripRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Point_of_InterestServiceImpl implements Services<Point_of_Interest> {

    @Autowired
    Point_of_InterestRepository point_of_InterestRepository;

    @Override
    public Page findAll(Pageable pageable, String searchText) {
        return point_of_InterestRepository.findAllPoint_of_Interests(pageable, searchText);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return point_of_InterestRepository.findAll(pageable);
    }

    @Override
    public Point_of_Interest findById(Long id) {
        return point_of_InterestRepository.findById(id).get();
    }

    @Override
    public Point_of_Interest saveOrUpdate(Point_of_Interest point_of_Interest) {

        return point_of_InterestRepository.save(point_of_Interest);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            point_of_InterestRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
