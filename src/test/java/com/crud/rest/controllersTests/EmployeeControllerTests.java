package com.crud.rest.controllersTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.crud.rest.controller.EmployeeController;
import com.crud.rest.dao.EmployeeService;
import com.crud.rest.dao.EmployeeServiceImpl;
import com.crud.rest.model.Employee;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {

	private EmployeeController empController;
	
	// Test function for Create Employee
	@Test
	public void testCreateEmployee() {
		empController = new EmployeeController();
		
		//Preparing the Mock
		EmployeeService empService = Mockito.mock(EmployeeServiceImpl.class);
		empController.setEmployeeService(empService);
		
		// Preparing the data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setId(0);
	
		// Set data to mock object
		Mockito.when(empService.createEmployee(emp)).thenReturn(emp);
		
		// Calling actual method
		URI uri = null;
		ResponseEntity <Employee> result = empController.createEmployee(emp, uri);
		
		// Asserting
		
		assertEquals(result.getBody().getId(), expectEmp.getId());
	}
	
	// Test function for Get Employees
	@Test
	public void testGetEmployees() {
		empController = new EmployeeController();
		
		// Preparing the mock
		EmployeeService empService = Mockito.mock(EmployeeServiceImpl.class);
		empController.setEmployeeService(empService);
		
		// Preparing the data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setId(0);
		
		// Set data to mock object
		List <Employee> emps = new ArrayList <>();
		
		emps.add(emp);
		
		Mockito.when(empService.getEmployees()).thenReturn(emps);
		
		// Calling actual method
		ResponseEntity<List<Employee>> result = empController.getEmployees();
		
		// Asserting
		assertEquals(result.getBody().get(0).getId(),expectEmp.getId());
	}
	
	
	// Test function for Get Employee By Id
	@Test
	public void testGetEmployeeById() {
		empController = new EmployeeController();
		
		// Preparing the mock
		EmployeeService empService = Mockito.mock(EmployeeServiceImpl.class);
		empController.setEmployeeService(empService);
		
		// Preparing the data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setId(0);
		
		// Set data to mock object
		Mockito.when(empService.getEmployeeById(emp.getId())).thenReturn(emp);
		
		// Calling actual method
		ResponseEntity<Employee> result = empController.getEmployeeById(emp.getId(), emp);
		
		// Asserting
		assertEquals(result.getBody().getId(), expectEmp.getId());
	}
	
	// Test function for Update Employee
	@Test
	public void testUpdateEmployee() {
		empController = new EmployeeController();
		
		// Preparing the Mock
		EmployeeService empService = Mockito.mock(EmployeeServiceImpl.class);
		empController.setEmployeeService(empService);
		
		// Preparing the data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setId(0);
		
		// Set data to mock object
		Mockito.when(empService.updateEmployee(emp)).thenReturn(emp);
		
		// Calling actual method
		ResponseEntity<Employee> result = empController.updateEmployee(emp.getId(), emp);
		
		// Asserting
		assertEquals(result.getBody().getId(), expectEmp.getId());
	}
	
	
	// Test function for Delete Employee
	@Test
	public void testDeleteEmployee() {
		empController = new EmployeeController();
		
		// Preparing the Mock
		EmployeeService empService = Mockito.mock(EmployeeServiceImpl.class);
		empController.setEmployeeService(empService);
		
		// Preparing the data
		Employee emp = new Employee();
		emp.setId(0);
		
		
		// Calling the actual method
		empController.deleteEmployee(emp.getId());
		
		// Verify if the delete method is called.
		Mockito.verify(empService).deleteEmployee(emp.getId());
	}
}
