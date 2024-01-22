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

import com.organization.entities.Department;
import com.organization.service.DepartmentService;
import com.organization.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private RoleService roleService;

	// Create Department
	@PostMapping("/save")
	public ResponseEntity<Object> createDepartment(@Valid @RequestBody Department department) {
		Department createdDepartment = departmentService.createDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
	}

	// Get All Departments
	@GetMapping("/all")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	// Get Department By ID
	@GetMapping("/{id}")
	public ResponseEntity<Object> getDepartment(@PathVariable(value = "id") Long departmentId) {
		Department department = departmentService.getDepartment(departmentId);
		if (department != null) {
			return ResponseEntity.ok(department);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
	}

	// Update Department
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDepartment(@PathVariable Long id,
			@Valid @RequestBody Department updatedDepartment) {
		Department updated = departmentService.updateDepartment(id, updatedDepartment);
		if (updated != null) {
			return ResponseEntity.ok(updated);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
	}

	// Delete Department
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable(value = "id") Long departmentId) {
		Department department = departmentService.getDepartment(departmentId);
		if (department != null) {
			// Check if there are any employees associated with the Role
			if (roleService.existsByDepartmentId(departmentId)) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Cannot delete department with associated role");
			}
			departmentService.deletedepartment(departmentId);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department not found");
		}
	}
}
