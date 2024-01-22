package com.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entities.Role;
import com.organization.repository.RoleRepository;
import com.organization.service.RoleService;

import jakarta.validation.Valid;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role createRole(@Valid Role role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRole(Long roleId) {
		return roleRepository.findById(roleId).orElse(null);
	}

	public Role updateRole(Long id, @Valid Role updatedRole) {
		Role existingRole = roleRepository.findById(id).orElse(null);
		if (existingRole != null) {
			existingRole.setName(updatedRole.getName());

			return roleRepository.save(existingRole);
		}
		return null;
	}

	@Override
	public void deleteRole(Long roleId) {
		roleRepository.deleteById(roleId);
	}

	@Override
	public boolean existsByDepartmentId(Long departmentId) {
		return roleRepository.existsByDepartmentId(departmentId);
	}

}
