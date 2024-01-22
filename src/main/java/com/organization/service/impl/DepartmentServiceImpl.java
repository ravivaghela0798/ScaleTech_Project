package com.organization.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entities.Department;
import com.organization.repository.DepartmentRepository;
import com.organization.service.DepartmentService;

import jakarta.validation.Valid;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department getDepartment(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}

	@Override
	public Department createDepartment(@Valid Department department) {
		return departmentRepository.save(department);
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department updateDepartment(Long id, @Valid Department updatedDepartment) {
		Department existingDepartment = departmentRepository.findById(id).orElse(null);
		if (existingDepartment != null) {
			BeanUtils.copyProperties(updatedDepartment, existingDepartment);
			return departmentRepository.save(existingDepartment);
		}
		return null;
	}

	@Override
	public void deletedepartment(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

}
