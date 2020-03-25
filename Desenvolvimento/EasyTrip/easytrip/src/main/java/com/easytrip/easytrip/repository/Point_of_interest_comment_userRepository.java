package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Point_of_interest_comment_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Point_of_interest_comment_userRepository extends JpaRepository<Point_of_interest_comment_user, Long> {
    List<Point_of_interest_comment_user> findByPoint_of_interestId(Long point_of_interestId);
    List<Point_of_interest_comment_user> findByPersonId(Long personId);
}
