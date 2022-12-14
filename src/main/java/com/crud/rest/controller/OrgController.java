package com.crud.rest.controller;

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

import com.crud.rest.dao.OrgService;
import com.crud.rest.model.Organization;

@RestController
public class OrgController {

	@Autowired
	private OrgService orgService;
	
	// Get all organizations      ---> GET
	@GetMapping("/organization")
	public ResponseEntity <List <Organization> > getOrganization(){
		return ResponseEntity.ok().body(this.orgService.getOrgs());
	}
	
	// Get organization by id
	@GetMapping("/organization/{id}")
	public ResponseEntity <Organization> getOrganizationById(@PathVariable long id){
		return ResponseEntity.ok().body(this.orgService.getOrgById(id));
		
	}
	
	// Add organization           ---> POST 
	@PostMapping("/organization")
	public ResponseEntity <Organization> createOrganization(@RequestBody Organization org){
		return ResponseEntity.ok().body(this.orgService.createOrganization(org));
	}
	
	
	// Update organization by id  ---> PUT
	@PutMapping("organization/{id}")
	public ResponseEntity <Organization> updateOrganization(@PathVariable long id, @RequestBody Organization org){
		org.setOrgId(id);
		return ResponseEntity.ok().body(this.orgService.updateOrganization(org));
	}
	
	
	// Delete Organization by id ---> DELETE
	@DeleteMapping("/organization/{id}")
	public HttpStatus deleteOrganization(@PathVariable long id){
		this.orgService.deleteOrganization(id);
		return HttpStatus.OK;
	}

	public OrgService getOrgService() {
		return orgService;
	}

	public void setOrgService(OrgService orgService) {
		this.orgService = orgService;
	}
	
	
}
