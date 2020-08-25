package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Trip;
import com.easytrip.easytrip.repository.TripRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements Services<Trip> {


    @Autowired
    TripRepository tripRepository;


    public Page findByOrigin(Pageable pageable, String searchText) {
        return tripRepository.findByOrigin(pageable, searchText);
    }

    public Page findByDestiny(Pageable pageable, String searchText) {
        return tripRepository.findByDestiny(pageable, searchText);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return tripRepository.findAll(pageable);
    }

    @Override
    public Trip findById(Long id) {
        return tripRepository.findById(id).get();
    }

    @Override
    public Trip saveOrUpdate(Trip trip) {

        return tripRepository.save(trip);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            tripRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
