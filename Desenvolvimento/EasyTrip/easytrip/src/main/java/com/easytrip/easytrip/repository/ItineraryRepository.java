package com.easytrip.easytrip.repository;


import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.models.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {

    @Query("FROM Itinerary b WHERE b.id LIKE %:searchText% ")
    Page<Itinerary> findAllItinerarys(Pageable pageable, @Param("searchText") String searchText);
}
