package com.crud.rest.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.rest.exception.ResourceNotFoundException;
import com.crud.rest.model.Employee;
import com.crud.rest.model.Organization;
import com.crud.rest.repository.EmployeeRepository;
import com.crud.rest.repository.OrgRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
    private OrgRepository orgRepo;
    
	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employeeDb = this.employeeRepository.findById(employee.getId());
		
		if(employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(employee.getId());
			employeeUpdate.setName(employee.getName());
			employeeRepository.save(employeeUpdate);
			return employeeUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + employee.getId());
		}		
	}
	
	
	@Override
	public List<Employee> getEmployees() {
		return this.employeeRepository.findAll();
	}

	
	@Override
	public Employee getEmployeeById(long employeeId) {
		
		Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
		
		if(employeeDb.isPresent()) {
			return employeeDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
	}


	@Override
	public void deleteEmployee(long employeeId) {
		Optional<Employee> employeeDb = this.employeeRepository.findById(employeeId);
		
		if(employeeDb.isPresent()) {
			this.employeeRepository.delete(employeeDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + employeeId);
		}
		
	}

	
	// Post Employee to an organization
	@Override
	public Employee createEmployeeWithId(Employee employee, long id) {
		
		Organization org = orgRepo.findById(id).orElseThrow();
		employee.setOrg(org);
		
		return employeeRepository.save(employee);	
		}

	
	// Getter and Setter
	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}


	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

}
