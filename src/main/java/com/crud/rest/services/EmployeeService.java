package com.crud.rest.services;

import java.util.List;

import com.crud.rest.model.Employee;

public interface EmployeeService {
	
    Employee createEmployee(Employee employee);
	
    Employee updateEmployee(Employee employee);
	
    public List <Employee> getEmployees();
    
    Employee getEmployeeById(long EmployeeId);
    
    void deleteEmployee(long id);
}
