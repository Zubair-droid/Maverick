package com.crud.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository <Employee, Long>{

	
}
