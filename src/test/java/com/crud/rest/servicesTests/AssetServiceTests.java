package com.crud.rest.servicesTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.dao.AssetServiceImpl;
import com.crud.rest.model.Asset;
import com.crud.rest.repository.AssetRepository;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTests {

	@Autowired
	private AssetServiceImpl assetService;
	
	
	// Test function for create asset
   @Test
   public void testCreateAssset() {
	   assetService = new AssetServiceImpl();
      
	   // Preparing mock	
	  AssetRepository assetRepo = Mockito.mock(AssetRepository.class);
	  assetService.setAssetRepository(assetRepo);
	  
	  // Preparing data
	  
	  Asset expAsset = new Asset();
	  expAsset.setAssetId(0);
	  expAsset.setAssetName("mouse");
	  
	  Asset asset = new Asset();
	  asset.setAssetId(0);
	  
	  // Preparing mock object
	  Mockito.when(assetRepo.save(asset)).thenReturn(asset);
	  
	
	  // Calling actual method
	  Asset result = assetService.createAsset(asset);
	  
	  // Assertion
	  assertEquals(result.getAssetId(), expAsset.getAssetId());
   }
	
	
	// Test function for get assets
	@Test
	public void testGetAssets() {
		assetService = new AssetServiceImpl();
    //Preparing mock
		
		AssetRepository assetRepo = Mockito.mock(AssetRepository.class);
		assetService.setAssetRepository(assetRepo);
		  
		// Preparing data
		  
		Asset expAsset = new Asset();
		expAsset.setAssetId(0);
			
	 	List <Asset> assets = new ArrayList<>();
		assets.add(expAsset);
		
		// Setting data to mock object
		Mockito.when(assetRepo.findAll()).thenReturn(assets);
		
		// Calling actual method
		List <Asset> result = assetService.getAssets();
		System.out.println(result);
		
		// Assertion
		assertEquals(result.get(0).getAssetId(), expAsset.getAssetId());
		
	}
	
	// Test function for get asset by id
	@Test
	public void testGetAssetById() {
		assetService = new AssetServiceImpl();
		
		//Preparing the mock
		AssetRepository assetRepo = Mockito.mock(AssetRepository.class);
		assetService.setAssetRepository(assetRepo);
		
		// Preparing the data
		Asset expAsset = new Asset();
		expAsset.setAssetId(0);
		expAsset.setAssetName("monitor");
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		
		// Setting data to mock object
		Mockito.when(assetRepo.findById(asset.getAssetId())).thenReturn(Optional.ofNullable(asset));
		
		// Calling the actual method
		Asset result =  assetService.getAssetById(asset.getAssetId());
		
		//Asserting
		
		assertEquals(result.getAssetId(), expAsset.getAssetId());
	}
	
	// Test function for update asset
	@Test
	public void testUpdateASset() {
		assetService = new AssetServiceImpl();
		
		// Preparing mock
		AssetRepository assetRepo = Mockito.mock(AssetRepository.class);
		assetService.setAssetRepository(assetRepo);
		
		// Preparing data
		Asset expAsset = new Asset();
		expAsset.setAssetId(0);
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		// Set data to mock object
		Mockito.when(assetRepo.findById(asset.getAssetId())).thenReturn(Optional.ofNullable(asset));
		
		// Calling actual method
		Asset result = assetService.updateAsset(asset);
		
		
		// Assertion
		assertEquals(result.getAssetId(), expAsset.getAssetId());
	}
	
	// Test function for delete asset
	@Test
	public void testDeleteAsset() {
		assetService = new AssetServiceImpl();
		
		// Preparing the mock
		AssetRepository assetRepo = Mockito.mock(AssetRepository.class);
		assetService.setAssetRepository(assetRepo);
		
		// Preparing data
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		// Set data to mock object
		Mockito.when(assetRepo.findById(asset.getAssetId())).thenReturn(Optional.ofNullable(asset));
		
		// Calling actual method
		assetService.deleteAsset(asset.getAssetId());
		
		
		// Verify if the delete method is called.
		Mockito.verify(assetRepo).delete(asset);
	}
}
