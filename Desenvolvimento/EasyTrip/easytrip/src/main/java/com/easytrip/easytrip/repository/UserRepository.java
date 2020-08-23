package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User b WHERE b.email LIKE %:searchText%  ")
    Page<User> findByEmail(Pageable pageable, @Param("searchText") String searchText);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    /*Page<User> findByRoleId(Long roleId, Pageable pageable);

    Optional<User> findByIdAndRoleId(Long id, Long roleId);

    Page<User> findByTripId(Long tripId, Pageable pageable);

    Optional<User> findByIdAndTripId(Long id, Long tripId);

    Page<User> findByPoint_of_InterestId(Long point_of_InterestId, Pageable pageable);

    Optional<User> findByIdAndPoint_of_InterestId(Long id, Long point_of_InterestId);

    Page<User> findByImageId(Long imageId, Pageable pageable);

    Optional<User> findByIdAndImageId(Long id, Long imageId);*/

}
