package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.domain.Travel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

    @Query("FROM Travel b WHERE b.Origin LIKE %:searchText% ")
    Page<Travel> findAllTravels(Pageable pageable, @Param("searchText") String searchText);
}