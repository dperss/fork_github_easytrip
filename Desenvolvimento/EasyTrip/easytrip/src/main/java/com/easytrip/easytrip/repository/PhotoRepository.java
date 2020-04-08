package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Photo;
import com.easytrip.easytrip.model.Photo_point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findByPersonId(Long personId);
    List<Photo> findByPhoto_pointId(Long photo_pointId);
}
