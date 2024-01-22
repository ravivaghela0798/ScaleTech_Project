package com.organization.service;

import java.util.List;

import com.organization.entities.Role;

import jakarta.validation.Valid;

public interface RoleService {

	Role createRole(@Valid Role role);

	List<Role> getAllRole();

	Role getRole(Long roleId);

	Role updateRole(Long id, @Valid Role updatedRole);

	void deleteRole(Long roleId);

	boolean existsByDepartmentId(Long departmentId);

}
