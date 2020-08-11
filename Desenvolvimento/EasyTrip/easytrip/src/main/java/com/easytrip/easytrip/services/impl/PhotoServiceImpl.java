package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Photo;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.repository.PhotoRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements Services<Photo> {

    PhotoRepository photoRepository;



    public Page findAll(Pageable pageable, String searchText) {
        return photoRepository.findAllPhotos(pageable, searchText);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return photoRepository.findAll(pageable);
    }

    @Override
    public Photo findById(Long id) {
        return photoRepository.findById(id).get();
    }

    @Override
    public Photo saveOrUpdate(Photo photo) {

        return photoRepository.save(photo);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            photoRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
