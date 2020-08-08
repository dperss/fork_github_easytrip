package com.easytrip.easytrip.repository;

import com.easytrip.easytrip.models.ERole;
import com.easytrip.easytrip.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
