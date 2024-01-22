package com.organization.service;

import java.util.List;

import com.organization.entities.Department;

import jakarta.validation.Valid;

public interface DepartmentService {

	Department getDepartment(Long id);

	Department createDepartment(@Valid Department department);

	List<Department> getAllDepartments();

	Department updateDepartment(Long id, Department updatedDepartment);

	void deletedepartment(Long departmentId);

}
