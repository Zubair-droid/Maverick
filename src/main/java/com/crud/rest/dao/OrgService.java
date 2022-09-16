package com.crud.rest.dao;

import java.util.List;

import com.crud.rest.model.Organization;

public interface OrgService {
	
    Organization createOrganization(Organization org);
	
    Organization updateOrganization(Organization org);
	
    public List <Organization> getOrgs();
    
    Organization getOrgById(long id);
    
    void deleteOrganization(long id);

}
