package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByPersonId(Long personId);
}
