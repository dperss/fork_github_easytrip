package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("FROM Person b WHERE b.nome LIKE %:searchText% OR b.email LIKE %:searchText%  ")
    Page<Person> findAllPersons(Pageable pageable, @Param("searchText") String searchText);
}
