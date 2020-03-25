package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Itinerary_point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Itinerary_pointRepository extends JpaRepository<Itinerary_point, Long> {
    List<Itinerary_point> findByItineraryId(Long itineraryId);
    List<Itinerary_point> findBypoint_of_interestId(Long point_of_interestId);

}
