package com.session.october.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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
	private final AsyncService asyncService;

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

	public void deleteEmployeeById(Long id) throws InterruptedException {
		// 1 -> use DeleteById function of Jpa
//		employeeRepository.deleteById(id); // This will simply delete the entry from database
//		// If there will be no entry availble in database, It won't raise any issue
//		
//		// 2 -> use Delete function of jpa
//		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Invalid Employee Id: " + id));
//		employeeRepository.delete(emp); // If there will be no entry in database with such details, it will throw an error

		// 3 -> We can write manual JPQL in Repository and use it
//		employeeRepository.deleteByEmployeeId(id);
		log.info("Started");
		CompletableFuture<Void> future = asyncService.sampleWaitMethod(5);
		CompletableFuture<Void> future1 = asyncService.sampleWaitMethod(7);
		CompletableFuture<Void> future2 = asyncService.sampleWaitMethod(10);
		CompletableFuture<Void> future3 = asyncService.sampleWaitMethod(15);
		CompletableFuture<Void> all = CompletableFuture.allOf(future, future1, future2, future3);
		all.join();
		log.info("Completed");
	}
}