package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.models.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    @Query("FROM Trip b WHERE b.Origin LIKE %:searchText% ")
    Page<Trip> findAllTrips(Pageable pageable, @Param("searchText") String searchText);



}