package com.easytrip.easytrip.controller;


        import com.easytrip.easytrip.exception.ResourceNotFoundException;
        import com.easytrip.easytrip.model.Person;
        import com.easytrip.easytrip.model.Photo_point;
        import com.easytrip.easytrip.repository.PersonRepository;
        import com.easytrip.easytrip.repository.Photo_pointRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;

@RestController
public class Photo_pointController {

    @Autowired
    private Photo_pointRepository photo_pointRepository;

    //GET
    @GetMapping("/photo_points")
    public Page<Photo_point> getPhoto_point(Pageable pageable) {
        return photo_pointRepository.findAll(pageable);
    }

    //POST
    @PostMapping("/photo_points")
    public Photo_point createPhoto_points(@Valid @RequestBody Photo_point photo_point) {
        return photo_pointRepository.save(photo_point);
    }



    //DELETE
    @DeleteMapping("/photo_points/{photo_pointId}")
    public ResponseEntity<?> deletePerson(@PathVariable Long photo_pointId) {
        return photo_pointRepository.findById(photo_pointId)
                .map(photo_point -> {
                    photo_pointRepository.delete(photo_point);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Photo point not found with id " + photo_pointId));
    }
}

