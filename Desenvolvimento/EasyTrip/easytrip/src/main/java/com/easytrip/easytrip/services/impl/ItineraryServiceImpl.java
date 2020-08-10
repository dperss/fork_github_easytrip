package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.models.Photo;
import com.easytrip.easytrip.repository.ItineraryRepository;
import com.easytrip.easytrip.repository.PhotoRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItineraryServiceImpl implements Services<Itinerary> {

    ItineraryRepository itineraryRepository;


    @Override
    public Page findAll(Pageable pageable, String searchText) {
        return itineraryRepository.findAllItinerarys(pageable, searchText);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return itineraryRepository.findAll(pageable);
    }

    @Override
    public Itinerary findById(Long id) {
        return itineraryRepository.findById(id).get();
    }

    @Override
    public Itinerary saveOrUpdate(Itinerary itinerary) {

        return itineraryRepository.save(itinerary);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            itineraryRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
