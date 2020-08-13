package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Image;
import com.easytrip.easytrip.services.impl.ImageServiceImpl;
import io.swagger.models.Model;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/test/images")
public class ImageController implements Controller<Image> {


    @Autowired
    private ImageServiceImpl photoService;



    @Override
    public ResponseEntity<Page<Image>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


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
    public ResponseEntity<Image> findById(Long id) {

        return new ResponseEntity<>(photoService.findById(id), HttpStatus.OK);


    }



    @Override
    public ResponseEntity<Image> save(Image image) {
        System.out.println("Image created");
        return new ResponseEntity<>(photoService.saveOrUpdate(image), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Image> update(Image image) {
        System.out.println("Image Updated");
        return new ResponseEntity<>(photoService.saveOrUpdate(image), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Image deleted ID:" + id);
        return new ResponseEntity<>(photoService.deleteById(id), HttpStatus.OK);
    }

}