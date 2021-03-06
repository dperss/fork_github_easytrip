package com.easytrip.easytrip.services.impl;

import com.easytrip.easytrip.models.Image;
import com.easytrip.easytrip.models.User;
import com.easytrip.easytrip.repository.ImageRepository;
import com.easytrip.easytrip.services.Services;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageServiceImpl implements Services<Image> {

    @Autowired
    private ImageRepository imageRepository;



    @Override
    public Page findAll(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }


    public Optional<Image> findByName(String name) {
        return imageRepository.findByName(name);
    }



    @Override
    public  Image findById(Long id) {
        return imageRepository.findById(id).get();
    }
    @Override
    public Image saveOrUpdate(Image image) {

        return imageRepository.save(image);

    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            imageRepository.deleteById(id);
            jsonObject.put("message", "Trip deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
