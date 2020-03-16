package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
