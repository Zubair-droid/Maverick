package com.crud.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@JsonBackReference
	@ManyToOne()
	private Organization org;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(long id, String name) {
		//super();
		this.id = id;
		this.name = name;
		
	}
	
	public Employee(long id, String name, Organization org) {
		super();
		this.id = id;
		this.name = name;
		this.org = org;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
