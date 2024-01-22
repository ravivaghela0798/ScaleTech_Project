package com.organization.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.entities.Role;
import com.organization.service.EmployeeService;
import com.organization.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmployeeService employeeService;

	// Create Role
	@PostMapping("/save")
	public ResponseEntity<Object> createRole(@Valid @RequestBody Role role) {
		Role createdRole = roleService.createRole(role);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
	}

	// Get All Roles
	@GetMapping("/all")
	public List<Role> getAllRoles() {
		return roleService.getAllRole();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getRoleById(@PathVariable Long id) {
		Role role = roleService.getRole(id);
		if (role != null) {
			return ResponseEntity.ok(role);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
		}
	}

	// Update Role
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateRole(@PathVariable Long id, @Valid @RequestBody Role updatedRole) {
		Role updated = roleService.updateRole(id, updatedRole);
		if (updated != null) {
			return ResponseEntity.ok(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
		}
	}

	// Delete Role
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable(value = "id") Long roleId) {
		Role role = roleService.getRole(roleId);
		if (role != null) {
			if (employeeService.existsByRoleId(roleId)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot delete role with associated employees");
			}
			roleService.deleteRole(roleId);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
