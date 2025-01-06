package com.session.october.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.session.october.dtos.EmployeeRequest;
import com.session.october.entities.Department;
import com.session.october.entities.Employee;
import com.session.october.repositories.DepartmentRepository;
import com.session.october.repositories.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	public Employee createEmployee(EmployeeRequest request) {
		Optional<Department> opt = departmentRepository.findById(request.getDepartmentId()); // check for department in
																								// table
		if (opt.isEmpty()) {
			throw new RuntimeException("Invalid Department Id: " + request.getDepartmentId());
		}
		Department dept = opt.get();
		Employee employee = Employee.builder().name(request.getName()).department(dept).build();
		return employeeRepository.save(employee); // This will save in db
	}

	public List<Employee> fetchEmployeeByDepartmentName(String departmentName) {
		// I want to fetch Department by name
		Optional<Department> opt = departmentRepository.findByName(departmentName);
		if (opt.isEmpty()) {
			throw new RuntimeException("Invalid Department Name: " + departmentName);
		}
		Department dept = opt.get();
		List<Employee> employees = employeeRepository.findByDepartment_Id(dept.getId());
		return employees;
	}
}