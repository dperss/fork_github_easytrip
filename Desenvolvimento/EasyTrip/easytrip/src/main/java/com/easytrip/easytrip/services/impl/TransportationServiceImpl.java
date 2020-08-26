package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Accommodation;
import com.easytrip.easytrip.models.Transportation;
import com.easytrip.easytrip.repository.AccommodationRepository;
import com.easytrip.easytrip.repository.TransportationRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransportationServiceImpl implements Services<Transportation> {

    TransportationRepository transportationRepository;



    @Override
    public Page findAll(Pageable pageable) {
        return transportationRepository.findAll(pageable);
    }

    @Override
    public Transportation findById(Long id) {
        return transportationRepository.findById(id).get();
    }

    @Override
    public Transportation saveOrUpdate(Transportation transportation) {

        return transportationRepository.save(transportation);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            transportationRepository.deleteById(id);
            jsonObject.put("message", "Accommodation deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}