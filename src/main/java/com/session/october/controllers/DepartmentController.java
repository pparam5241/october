package com.session.october.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.october.entities.Department;
import com.session.october.services.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;

	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepartment() {
		return ResponseEntity.ok(departmentService.getAllDepartment());
	}
}