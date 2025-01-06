package com.session.october.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.session.october.entities.Department;
import com.session.october.repositories.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
	private final DepartmentRepository departmentRepository;

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}
}