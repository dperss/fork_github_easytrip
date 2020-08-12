package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.models.Photo;
import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.services.impl.ItineraryServiceImpl;
import com.easytrip.easytrip.services.impl.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/photos")
public class PhotoController implements Controller<Photo> {


    @Autowired
    private PhotoServiceImpl photoService;



    @Override
    public ResponseEntity<Page<Photo>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
            return new ResponseEntity<>(photoService.findAll(
                    PageRequest.of(
                            pageNumber, pageSize,
                            sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                    )
            ), HttpStatus.OK);}catch (Exception e){
            System.out.println("PError");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<Photo> findById(Long id) {

        return new ResponseEntity<>(photoService.findById(id), HttpStatus.OK);


    }



    @Override
    public ResponseEntity<Photo> save(Photo photo) {
        System.out.println("Photo created");
        return new ResponseEntity<>(photoService.saveOrUpdate(photo), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Photo> update(Photo photo) {
        System.out.println("Photo Updated");
        return new ResponseEntity<>(photoService.saveOrUpdate(photo), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Photo deleted ID:" + id);
        return new ResponseEntity<>(photoService.deleteById(id), HttpStatus.OK);
    }

}