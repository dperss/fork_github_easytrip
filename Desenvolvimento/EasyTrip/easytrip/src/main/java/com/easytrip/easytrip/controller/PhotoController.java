package com.easytrip.easytrip.controller;

        import com.easytrip.easytrip.exception.ResourceNotFoundException;
        import com.easytrip.easytrip.model.Itinerary_point;
        import com.easytrip.easytrip.model.Photo;
        import com.easytrip.easytrip.model.Point_of_interest_comment_user;
        import com.easytrip.easytrip.repository.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.List;

@RestController
public class PhotoController{


    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private Photo_pointRepository photo_pointRepository;



    //GET
    @GetMapping("/person/{personId}/photo")
    public List<Photo> getPersonByPersonId(@PathVariable Long personId) {
        return photoRepository.findByPersonId(personId);
    }
    //GET
    @GetMapping("/photo_point/{photo_pointId}/photo")
    public List<Photo> getPhotoBypPhoto_pointId(@PathVariable Long photo_pointId) {
        return photoRepository.findByPhoto_pointId(photo_pointId);
    }

    //POST
    @PostMapping("/person/{personId}/photo")
    public Photo addPerson(@PathVariable Long personId,
                                                    @Valid @RequestBody Photo photos) {
        return personRepository.findById(personId)
                .map(person -> {
                    photos.setPerson(person);
                    return photoRepository.save(photos);
                }).orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + personId));
    }
    //POST
    @PostMapping("/photo_point/{photo_pointId}/photo")
    public Photo addPhoto_point(@PathVariable Long photo_pointId,
                                            @Valid @RequestBody Photo photos) {
        return photo_pointRepository.findById(photo_pointId)
                .map(photo_point -> {
                    photos.setPhoto_point(photo_point);
                    return photoRepository.save(photos);
                }).orElseThrow(() -> new ResourceNotFoundException("Photo point not found with id " + photo_pointId));
    }



    @PutMapping("/photo_point/{photo_pointId}/person/{personId}/photos/{photoId}")
    public Photo updatePhoto(@PathVariable Long photoId,
                                                                               @PathVariable Long photo_pointId,
                                                                               @PathVariable Long personId,
                                                                               @Valid @RequestBody Photo photosRequest) {
        if(!photo_pointRepository.existsById(photo_pointId)) {
            throw new ResourceNotFoundException("Photo point of interest not found with id " + photo_pointId);
        }
        if(!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Person of interest comment usersId not found with id " + personId);
        }

        return photoRepository.findById(photoId)
                .map(photos -> {
                    photos.setPerson(photosRequest.getPerson());
                    photos.setPhoto_point(photosRequest.getPhoto_point());
                    return photoRepository.save(photos);
                }).orElseThrow(() -> new ResourceNotFoundException("Photo comment user point not found with id " + photoId));
    }


    @DeleteMapping("/photo_point/{photo_pointId}/person/{personId}/photos/{photoId}")
    public ResponseEntity<?> deletePhoto(@PathVariable Long photo_pointId,
                                                   @PathVariable Long personId,
                                                   @PathVariable Long photoId) {
        if(!photo_pointRepository.existsById(photo_pointId)) {
            throw new ResourceNotFoundException("Photo point not found with id " + photo_pointId);
        }
        if(!personRepository.existsById(personId)) {
            throw new ResourceNotFoundException("Person not found with id " + personId);
        }

        return photoRepository.findById(photoId)
                .map(photo -> {
                    photoRepository.delete(photo);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Photo not found with id " + photoId));

    }
}
