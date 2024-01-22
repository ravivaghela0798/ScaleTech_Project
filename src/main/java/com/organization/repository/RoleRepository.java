package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	boolean existsByDepartmentId(Long departmentId);

}
