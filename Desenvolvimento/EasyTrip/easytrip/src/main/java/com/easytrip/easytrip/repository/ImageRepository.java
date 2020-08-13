package com.easytrip.easytrip.repository;


import com.easytrip.easytrip.models.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("FROM Image b WHERE b.id LIKE %:searchText% ")
    Page<Image> findAllImages(Pageable pageable, @Param("searchText") String searchText);
}
