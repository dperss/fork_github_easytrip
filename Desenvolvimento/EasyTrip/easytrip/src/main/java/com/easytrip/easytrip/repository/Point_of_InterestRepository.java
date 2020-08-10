package com.easytrip.easytrip.repository;


import com.easytrip.easytrip.models.Point_of_Interest;
import com.easytrip.easytrip.models.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Point_of_InterestRepository extends JpaRepository<Point_of_Interest, Long> {

    @Query("FROM Point_of_Interest b WHERE b.name LIKE %:searchText% ")
    Page<Point_of_Interest> findAllPoint_of_Interests(Pageable pageable, @Param("searchText") String searchText);
}
