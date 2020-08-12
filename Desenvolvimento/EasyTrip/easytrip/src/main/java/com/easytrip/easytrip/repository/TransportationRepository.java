package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.models.Itinerary;
import com.easytrip.easytrip.models.Transportation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long>{

    @Query("FROM Transportation b WHERE b.id LIKE %:searchText% ")
    Page<Transportation> findAllTransportations(Pageable pageable, @Param("searchText") String searchText);
}



