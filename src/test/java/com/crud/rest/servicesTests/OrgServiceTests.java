package com.crud.rest.servicesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.crud.rest.dao.OrgServiceImpl;
import com.crud.rest.model.Organization;
import com.crud.rest.repository.OrgRepository;

@ExtendWith(MockitoExtension.class)
public class OrgServiceTests {

	private OrgServiceImpl orgService;
	
	@Test
	public void testCreateOrg() {
		orgService = new OrgServiceImpl();
		
		// Preparing Mock
		OrgRepository orgRepo = Mockito.mock(OrgRepository.class);
		orgService.setOrgRepo(orgRepo);
		
		// Preparing data
		Organization expectOrg = new Organization();
		expectOrg.setOrgName("Siemens");
		expectOrg.setOrgId(0);
		
		
		Organization org = new Organization();
		org.setOrgName("Siemens");
		
		// Set data to mock object
		Mockito.when(orgRepo.save(org)).thenReturn(org);
		
		
		// Calling actual method
		Organization result = orgService.createOrganization(org);
		System.out.println(result);
		
		
		// Assertion
		assertEquals(result.getOrgName(), expectOrg.getOrgName());
	}
	
	
	// Test function for getOrgs
	
	@Test
	public void testGetOrgs() {
		orgService = new OrgServiceImpl();
		
		// Preparing Mock
		OrgRepository orgRepo = Mockito.mock(OrgRepository.class);
		orgService.setOrgRepo(orgRepo);
		
		// Preparing data
		Organization expectOrg = new Organization();
		expectOrg.setOrgName("Siemens");
		expectOrg.setOrgId(1);
		
		List <Organization> orgs = new ArrayList<>();
		
		orgs.add(expectOrg);
		
		Organization org = new Organization();
		org.setOrgId(1);
		
		// Set data to mock object
		Mockito.when(orgRepo.findAll()).thenReturn(orgs);
		
		// Calling actual method
		List<Organization> result = orgService.getOrgs();
		System.out.println(result);
		
		
		// Assertion
		assertEquals(result.get(0).getOrgId(), expectOrg.getOrgId());
	}
	
	
	// Test function for getOrgById
	
	@Test
	public void testGetOrgById() {
		orgService = new OrgServiceImpl();
		
		// Preparing Mock
		OrgRepository orgRepo = Mockito.mock(OrgRepository.class);
		orgService.setOrgRepo(orgRepo);
		
		// Preparing data
		Organization expectOrg = new Organization();
		expectOrg.setOrgName("Siemens");
		expectOrg.setOrgId(1);
		
		
		Organization org = new Organization();
		org.setOrgId(1);
		
		// Set data to mock object
		Mockito.when(orgRepo.findById(org.getOrgId())).thenReturn(Optional.ofNullable(org));
		
		// Calling actual method
		Organization result = orgService.getOrgById(org.getOrgId());
		System.out.println(result);
		
		
		// Assertion
		assertEquals(result.getOrgId(), expectOrg.getOrgId());
	}
	
	
	// Test function for UpdateOrg
	@Test
	public void testUpdate() {
		orgService = new OrgServiceImpl();
		
		// Preparing Mock
		OrgRepository orgRepo = Mockito.mock(OrgRepository.class);
		orgService.setOrgRepo(orgRepo);
		
		// Preparing data
		Organization expectOrg = new Organization();
		expectOrg.setOrgName("SMS");
		expectOrg.setOrgId(2);
		
		
		Organization org = new Organization();
		org.setOrgId(2);
		
		
		// Set data to mock object
		Mockito.when(orgRepo.findById(org.getOrgId())).thenReturn(Optional.ofNullable(org));
		
		// Calling actual method
		Organization result = orgService.updateOrganization(org);
		System.out.println(result);
		
	
		// Assertion
		assertEquals(result.getOrgId(), expectOrg.getOrgId());
	}
	

	// Test function for DeleteOrg
		@Test
		public void testDelete() {
			orgService = new OrgServiceImpl();
			
			// Preparing Mock
			OrgRepository orgRepo = Mockito.mock(OrgRepository.class);
			orgService.setOrgRepo(orgRepo);
			
			// Preparing data
			
			Organization org = new Organization();
			org.setOrgId(1);
			
			// Set data to mock object
			Mockito.when(orgRepo.findById(org.getOrgId())).thenReturn(Optional.ofNullable(org));
			
			// Calling actual method
			orgService.deleteOrganization(org.getOrgId());
			
			// Verify if the delete method is called.
			Mockito.verify(orgRepo).delete(org);
			
	
		}
}
