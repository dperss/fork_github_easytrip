package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Accommodation;
import com.easytrip.easytrip.repository.AccommodationRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccommodationServiceImpl implements Services<Accommodation> {


    @Autowired
    AccommodationRepository accommodationRepository;


    public Page findByLocation(Pageable pageable, String searchText) {
        return accommodationRepository.findByLocation(pageable, searchText);
    }

    public Page findByName(Pageable pageable, String searchText) {
        return accommodationRepository.findByName(pageable, searchText);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return accommodationRepository.findAll(pageable);
    }

    @Override
    public Accommodation findById(Long id) {
        return accommodationRepository.findById(id).get();
    }

    @Override
    public Accommodation saveOrUpdate(Accommodation trip) {

        return accommodationRepository.save(trip);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            accommodationRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
