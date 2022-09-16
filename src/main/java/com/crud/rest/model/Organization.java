package com.crud.rest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "organizations")
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orgId;
	
	@Column(name = "orgName")
	private String orgName;
	
	// Mapping Employee table to Organization. / Managed by Organization
	@JsonManagedReference
	@OneToMany(mappedBy = "org", cascade = CascadeType.ALL)
	private List <Employee> employee;
	
	// Mapping Asset table to Organization. / Managed by Organization
	@JsonManagedReference
	@OneToMany(mappedBy = "org", cascade = CascadeType.ALL)
	private List <Asset> asset;
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Asset> getAsset() {
		return asset;
	}
	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}
	
	public Organization(long orgId, String orgName, List<Employee> employee, List<Asset> asset) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.employee = employee;
		this.asset = asset;
	}
	
	public long getOrgId() {
		return orgId;
	}
	public void setOrgId(long orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public Organization(long orgId, String orgName) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
	}
	
	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgName=" + orgName + "]";
	}
	
	
	
	
	
}
