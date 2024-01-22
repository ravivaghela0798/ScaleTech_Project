package com.organization.service;

import java.util.List;

import com.organization.entities.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

	boolean existsByRoleId(Long roleId);

	boolean existsByEmail(String email);

	Employee saveEmployee(@Valid Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployee(Long employeeId);

	Employee updateEmployee(Long id, @Valid Employee updatedEmployee);

	void deleteEmployee(Long employeeId);

}
