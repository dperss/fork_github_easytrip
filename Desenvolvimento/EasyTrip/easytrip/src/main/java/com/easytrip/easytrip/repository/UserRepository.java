package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User b WHERE b.nome LIKE %:searchText% OR b.email LIKE %:searchText%  ")
    Page<User> findAllPersons(Pageable pageable, @Param("searchText") String searchText);

    User findByEmail(String email);
}