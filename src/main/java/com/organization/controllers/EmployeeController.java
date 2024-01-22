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

import com.organization.entities.Employee;
import com.organization.entities.Role;
import com.organization.service.EmployeeService;
import com.organization.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	// Create Employee
	@PostMapping("/save")
	public ResponseEntity<Object> createEmployee(@Valid @RequestBody Employee employee) {

		if (employeeService.existsByEmail(employee.getEmail())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
		}

		Role role = roleService.getRole(employee.getRole().getId());
		if (role == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role not found");
		}
		employee.setRole(role);

		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));

	}

	// Get All Employees
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee();
	}

	// Get Employee By ID
	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
	}

	// Update Employee
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee updatedEmployee) {
		Employee updated = employeeService.updateEmployee(id, updatedEmployee);
		if (updated != null) {
			return ResponseEntity.ok(updated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
		}
	}

	// Delete Employee
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
		Employee employee = employeeService.getEmployee(employeeId);
		if (employee != null) {
			employeeService.deleteEmployee(employeeId);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
		}
	}
}
