package com.crud.rest.servicesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.rest.dao.EmployeeServiceImpl;
import com.crud.rest.model.Employee;
import com.crud.rest.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {


	private EmployeeServiceImpl empService;
	
	
	// Test function for Create Employee
	
	@Test
	public void testCreateEmployee() {
		empService  = new EmployeeServiceImpl();
		
		// Preparing Mock
		EmployeeRepository empRepo = Mockito.mock(EmployeeRepository.class);
		empService.setEmployeeRepository(empRepo);
		
		// Preparing data
		Employee expectEmp = new Employee();
		expectEmp.setName("gary");
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setName("gary");
		
		// Set data to mock object
		Mockito.when(empRepo.save(emp)).thenReturn(emp);
		
		// Calling actual method with mock
		Employee result = empService.createEmployee(emp);
		
		// Asserting
		assertEquals(result.getId(), expectEmp.getId());
	}
	
	
	
	// Test function for getEmployees
	
	@Test
	public void testGetEmployees() {
		empService  = new EmployeeServiceImpl();
		
		// Preparing Mock
		EmployeeRepository empRepo = Mockito.mock(EmployeeRepository.class);
		empService.setEmployeeRepository(empRepo);
		
		// Preparing data
		Employee expectEmp = new Employee();
		expectEmp.setId(1);
		
		List <Employee> emps = new ArrayList<>();
		emps.add(expectEmp);
		
		
		// Set data to mock object
		
		Mockito.when(empRepo.findAll()).thenReturn(emps);

		// Calling actual method with mock
		
		List<Employee> result = empService.getEmployees();
		System.out.println(result);
		
		// Asserting
		assertEquals(result.get(0).getId(), expectEmp.getId());
	}
	
	
	
	// Test function for getEmployeeById
	
	@Test
	public void testGetEmployeeById() {
		empService  = new EmployeeServiceImpl();
		
		// Preparing Mock
		EmployeeRepository empRepo = Mockito.mock(EmployeeRepository.class);
		empService.setEmployeeRepository(empRepo);
		
		// Preparing data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setId(0);
		
		// Set data to mock object
		Mockito.when(empRepo.findById(emp.getId())).thenReturn(Optional.ofNullable(emp));
		
		// Calling actual method with mock
		Employee result = empService.getEmployeeById(emp.getId());
		
		// Asserting
		assertEquals(expectEmp.getId(), result.getId());
	}
	
	
	
	// Test function for updateEmployee
	
	@Test
	public void testUpdateEmployee() {
		empService  = new EmployeeServiceImpl();
		
		// Preparing Mock
		EmployeeRepository empRepo = Mockito.mock(EmployeeRepository.class);
		empService.setEmployeeRepository(empRepo);
		
		// Preparing data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);
		
		Employee emp = new Employee();
		emp.setId(0);
		
		// Set data to mock object
		
		Mockito.when(empRepo.findById(emp.getId())).thenReturn(Optional.ofNullable(emp));
		// Calling actual method with mock

		Employee result = empService.updateEmployee(emp);
		System.out.println(result);
		
		// Asserting
		assertEquals(emp.getId(), expectEmp.getId());
	}
	
	
	// Test function for deleteEmployee
	
	@Test
	public void testDeleteEmployee() {
		empService  = new EmployeeServiceImpl();
		
		// Preparing Mock
		EmployeeRepository empRepo =  Mockito.mock(EmployeeRepository.class);
		empService.setEmployeeRepository(empRepo);
		
		// Preparing data
		Employee expectEmp = new Employee();
		expectEmp.setId(0);

		
		Employee emp = new Employee();
		emp.setId(0);
		
		// Set data to mock object
		Mockito.when(empRepo.findById(emp.getId())).thenReturn(Optional.ofNullable(emp));
		
		// Calling actual method with mock
		empService.deleteEmployee(0);
		
		// Verify if the delete method is called.
		Mockito.verify(empRepo).delete(emp);
	}
}
