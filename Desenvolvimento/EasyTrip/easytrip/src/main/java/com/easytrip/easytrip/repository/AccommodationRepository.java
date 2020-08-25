package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.models.Accommodation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Query("FROM Accommodation a WHERE a.Location LIKE %:searchText% ")
    Page<Accommodation> findByLocation(Pageable pageable, @Param("searchText") String searchText);

    @Query("FROM Accommodation b WHERE b.name LIKE %:searchText% ")
    Page<Accommodation> findByName(Pageable pageable, @Param("searchText") String searchText);


}


