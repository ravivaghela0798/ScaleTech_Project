package com.organization.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entities.Employee;
import com.organization.repository.EmployeeRepository;
import com.organization.service.EmployeeService;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public boolean existsByRoleId(Long roleId) {
		return employeeRepository.existsByRoleId(roleId);
	}

	@Override
	public boolean existsByEmail(String email) {
		return employeeRepository.existsByEmail(email);
	}

	@Override
	public Employee saveEmployee(@Valid Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	@Override
	public Employee updateEmployee(Long id, @Valid Employee updatedEmployee) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		if (existingEmployee != null) {
			BeanUtils.copyProperties(updatedEmployee, existingEmployee);
			return employeeRepository.save(existingEmployee);
		}
		return null;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
