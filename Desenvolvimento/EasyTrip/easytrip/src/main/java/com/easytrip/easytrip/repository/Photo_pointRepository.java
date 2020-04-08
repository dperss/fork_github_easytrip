package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Photo_point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Photo_pointRepository extends JpaRepository<Photo_point, Long> {

}
