package com.easytrip.easytrip.repository;


import com.easytrip.easytrip.models.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long>{

}



