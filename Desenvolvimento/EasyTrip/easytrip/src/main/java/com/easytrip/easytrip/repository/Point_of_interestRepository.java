package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Point_of_interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Point_of_interestRepository extends JpaRepository<Point_of_interest, Long> {

}
