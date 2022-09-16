package com.crud.rest.model;

//import java.util.List;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	// Mapping Assets to Employee (one employee can have many assets) ./ Managed by Employee
	//@JsonManagedReference
	//@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	//private List <Asset> asset;

//	public List<Asset> getAsset() {
//		return asset;
//	}

//	public void setAsset(List<Asset> asset) {
//		this.asset = asset;
//	}

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
	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
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
