package com.easytrip.easytrip.controllers.impl;

import com.easytrip.easytrip.controllers.Controller;
import com.easytrip.easytrip.models.Image;
import com.easytrip.easytrip.repository.ImageRepository;
import com.easytrip.easytrip.services.impl.ImageServiceImpl;
import io.swagger.models.Model;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/images")
public class ImageController implements Controller<Image> {


    @Autowired
    private ImageServiceImpl imageService;


    @PostMapping("/upload")
    public ResponseEntity<Image> uplaodImage(MultipartFile file) throws IOException {

            System.out.println("Original Image Byte Size - " + file.getBytes().length);
            Image img = new Image(file.getOriginalFilename(), file.getContentType(),compressBytes(file.getBytes()));

        return new ResponseEntity<Image>(imageService.saveOrUpdate(img), HttpStatus.CREATED);


    }

    @GetMapping(path = { "/get/{imageName}" })
    public Image getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<Image> retrievedImage = imageService.findByName(imageName);
        Image img = new Image(retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()));
        return img;
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

    @Override
    public ResponseEntity<Page<Image>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {


        try{
            return new ResponseEntity<>(imageService.findAll(
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

        return new ResponseEntity<>(imageService.findById(id), HttpStatus.OK);


    }



    @Override
    public ResponseEntity<Image> save(Image image) {
        System.out.println("Image created");
        return new ResponseEntity<>(imageService.saveOrUpdate(image), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Image> update(Image image) {
        System.out.println("Image Updated");
        return new ResponseEntity<>(imageService.saveOrUpdate(image), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {

        System.out.println("Image deleted ID:" + id);
        return new ResponseEntity<>(imageService.deleteById(id), HttpStatus.OK);
    }

}
