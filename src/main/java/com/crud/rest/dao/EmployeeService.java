package com.crud.rest.dao;

import java.util.List;

import com.crud.rest.model.Employee;

public interface EmployeeService {
	
    Employee createEmployee(Employee employee);
    
    Employee createEmployeeWithId(Employee employee, long id);

    Employee updateEmployee(Employee employee);
	
    public List <Employee> getEmployees();
    
    Employee getEmployeeById(long EmployeeId);
    
    void deleteEmployee(long id);
    
    

   
}
