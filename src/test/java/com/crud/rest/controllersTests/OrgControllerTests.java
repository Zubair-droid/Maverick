package com.crud.rest.controllersTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.crud.rest.controller.OrgController;
import com.crud.rest.dao.OrgService;
import com.crud.rest.dao.OrgServiceImpl;
import com.crud.rest.model.Organization;

@ExtendWith(MockitoExtension.class)
public class OrgControllerTests {

	
	private OrgController orgController;
	// Test function for Create
	@Test
	public void testCreateOrg() {
		orgController = new OrgController();
		
		// Preparing Mock
		OrgService orgService  = Mockito.mock(OrgServiceImpl.class);
		orgController.setOrgService(orgService);
		
	    // Preparing data
		Organization org = new Organization();
		org.setOrgId(0);
		
		Organization expOrg = new Organization();
		expOrg.setOrgId(0);
		
		// Set data to mock object
		Mockito.when(orgService.createOrganization(org)).thenReturn(expOrg);
		
		
		// Calling actual method
		ResponseEntity <Organization> result = orgController.createOrganization(org);
		System.out.println(result);
		
		// Assertion 
		assertEquals(result.getBody().getOrgId(), expOrg.getOrgId());
	}
	
	
	
	// Test function for get Orgs
	@Test
	public void testGetOrgs() {
		orgController = new OrgController();
		
		
		// Preparing Mock
		OrgService orgService = Mockito.mock(OrgServiceImpl.class);
		orgController.setOrgService(orgService);
		
		// Preparing data		
		Organization expOrg = new Organization();
		expOrg.setOrgId(0);
		
		List <Organization> orgs = new ArrayList<>();
		orgs.add(expOrg);
		
		Organization org = new Organization();
		org.setOrgId(0);
		
		
		
		// Set data to mock object
		Mockito.when(orgService.getOrgs()).thenReturn(orgs);
		
		
		// Calling actual method
		ResponseEntity<List<Organization>> result = orgController.getOrganization();
		System.out.println(result);

	
		// Assertion
		
		assertEquals(result.getBody().get(0).getOrgId(), expOrg.getOrgId());
	}
	
	
	// Test function for get Org By Id
	@Test
	public void testGetOrgById() {
		orgController = new OrgController();
		
		// Preparing Mock
		OrgService orgService = Mockito.mock(OrgServiceImpl.class);
		orgController.setOrgService(orgService);
		
		
		// Preparing data
		Organization expOrg = new Organization();
		expOrg.setOrgName("Siemens");
		
		
		Organization org = new Organization();
		org.setOrgName("Siemens");
		
		// Set data to mock object
		Mockito.when(orgService.getOrgById(org.getOrgId())).thenReturn(org);
		
		// Calling actual method
		ResponseEntity <Organization> result = orgController.getOrganizationById(org.getOrgId());
		
		//Assertion
		assertEquals(result.getBody().getOrgId(), expOrg.getOrgId());
	}
	
	// Test function for update Org
	@Test
	public void testUpdateOrg() {
		orgController = new OrgController();
		
		// Preparing mock
		OrgService orgService = Mockito.mock(OrgServiceImpl.class);
		orgController.setOrgService(orgService);
		
		//Preparing data
		Organization expectOrg = new Organization();
		expectOrg.setOrgId(0);
		
		Organization org = new Organization();
		org.setOrgId(0);
		
		// Set data to mock object
		Mockito.when(orgService.updateOrganization(org)).thenReturn(org);
		
		
		// Calling actual method
		ResponseEntity<Organization> result = orgController.updateOrganization(org.getOrgId(), org);
		
		
		// Asserting
		assertEquals(result.getBody().getOrgId(), expectOrg.getOrgId());
	}
	
	
	// Test function for delete Org
	@Test
	public void testDeleteOrg() {
		
		orgController  = new OrgController();
		
		// Preparing Mock
		OrgService orgService = Mockito.mock(OrgServiceImpl.class);
		orgController.setOrgService(orgService);
		
		// Preparing data
	
		Organization org = new Organization();
		org.setOrgId(0);
		
		
		// Calling actual method
		
		orgController.deleteOrganization(org.getOrgId());
		
		// Verify if the delete method is called.
		Mockito.verify(orgService).deleteOrganization(org.getOrgId());
	}	
}


// Instead DAO --- > Service

// Instead Service ---- > Controller