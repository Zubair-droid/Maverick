package com.crud.rest.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.rest.exception.ResourceNotFoundException;
import com.crud.rest.model.Organization;
import com.crud.rest.repository.OrgRepository;

@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgRepository orgRepo;

	@Override
	public Organization createOrganization(Organization org) {
		return orgRepo.save(org);
	}
	
	@Override
	public List<Organization> getOrgs() {
	   return this.orgRepo.findAll();
	}
	
	@Override
	public Organization updateOrganization( Organization org) {
		Optional<Organization> orgDb = this.orgRepo.findById(org.getOrgId());
		
		if(orgDb.isPresent()) {
			Organization orgUpdate = orgDb.get();
			orgUpdate.setOrgId(org.getOrgId());
			orgUpdate.setOrgName(org.getOrgName());
			orgRepo.save(orgUpdate);
			return orgUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + org.getOrgId());
		}		
	}
	

	@Override
	public Organization getOrgById(long id) {
		Optional<Organization> orgDb = this.orgRepo.findById(id);
		
		if(orgDb.isPresent()) {
			return orgDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

	// Setter
	public void setOrgRepo(OrgRepository orgRepo) {
		this.orgRepo = orgRepo;
	}

	@Override
	public void deleteOrganization(long id) {
		 Optional <Organization> orgDb = this.orgRepo.findById(id);
		
		if(orgDb.isPresent()) {
			this.orgRepo.delete(orgDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}	
	}
}
