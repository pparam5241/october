package com.session.october.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.session.october.entities.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByDepartment_Id(Long id);

//	@Query("delete from Employee e where e.id = :id")
//	void deleteByEmployeeId(Long id);

	@Modifying
	@Transactional
	@Query(value = "delete from employee e where e.id = :id", nativeQuery = true)
	void deleteByEmployeeId(Long id);
}