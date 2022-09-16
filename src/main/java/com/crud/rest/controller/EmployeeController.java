package com.crud.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.rest.dao.EmployeeService;
import com.crud.rest.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping("/employees")
	public ResponseEntity <List <Employee>> getEmployees(){
		return ResponseEntity.ok().body(employeeService.getEmployees());
	}
	
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id, @RequestBody Employee employee){
		return ResponseEntity.ok().body(this.employeeService.getEmployeeById(id));
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee, URI uri){
		return ResponseEntity.created(uri).body(this.employeeService.createEmployee(employee));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		employee.setId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}

	@DeleteMapping("/employees/{id}")
	public HttpStatus deleteEmployee(@PathVariable long id){
		this.employeeService.deleteEmployee(id);
		return HttpStatus.OK;
	}
	
	// Adding employee to an organization
	@PostMapping("/employees/{orgId}/org")
	public ResponseEntity<Employee> createEmployeeWithId(@RequestBody Employee employee, @PathVariable long orgId ){
		return ResponseEntity.ok().body(this.employeeService.createEmployeeWithId(employee, orgId));
	}


	public EmployeeService getEmployeeService() {
		return employeeService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
}
