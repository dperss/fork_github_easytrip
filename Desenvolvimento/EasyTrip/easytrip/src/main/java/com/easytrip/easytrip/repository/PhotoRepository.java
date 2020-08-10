package com.easytrip.easytrip.repository;


import com.easytrip.easytrip.models.Photo;
import com.easytrip.easytrip.models.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("FROM Photo b WHERE b.id LIKE %:searchText% ")
    Page<Photo> findAllPhotos(Pageable pageable, @Param("searchText") String searchText);
}
