package com.crud.rest.controllersTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.crud.rest.controller.AssetController;
import com.crud.rest.dao.AssetService;
import com.crud.rest.dao.AssetServiceImpl;
import com.crud.rest.model.Asset;

@ExtendWith(MockitoExtension.class)
public class AssetControllerTests {

	private AssetController assetController;
	
	// Test function for Create Asset
	@Test
	public void testCreateAsset() {
		
		assetController = new AssetController();
		
		// Preparing mock
		AssetService assetService = Mockito.mock(AssetServiceImpl.class);
		assetController.setAssetService(assetService);
		
		// Preparing data
		Asset expectAsset = new Asset();
		expectAsset.setAssetId(0);
		
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		// Setting data to mock object
		Mockito.when(assetService.createAsset(asset)).thenReturn(asset);
		
		// Calling actual method
		ResponseEntity<Asset> result = assetController.createAsset(asset);
		
		// Asserting
		
		assertEquals(result.getBody().getAssetId(), expectAsset.getAssetId());
	}
	
	// Test function for Get Assets
	@Test
	public void testGetAssets() {
		
		assetController = new AssetController();
		
		// Preparing Mock
		AssetService assetService = Mockito.mock(AssetServiceImpl.class);
		assetController.setAssetService(assetService);
		

		// Preparing data
		List <Asset> assets = new ArrayList<>();
		
		Asset expectAsset = new Asset();
		expectAsset.setAssetId(0);
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		assets.add(asset);
		
		// Set data to mock object
		Mockito.when(assetService.getAssets()).thenReturn(assets);
		
		// Calling actual object
		ResponseEntity<List<Asset>> result = assetController.getAssets();
		
		// Asserting
		assertEquals(result.getBody().get(0).getAssetId(), expectAsset.getAssetId());
	}
	
	
	// Test function for Get ASset By Id
	@Test
	public void testGetAssetById() {
		assetController = new AssetController();
		
		// Preparing Mock
		AssetService assetService = Mockito.mock(AssetServiceImpl.class);
		assetController.setAssetService(assetService);
		
		// Preparing data
		Asset expectAsset = new Asset();
		expectAsset.setAssetId(0);
		
		Asset asset = new Asset();
		asset.setAssetId(0);

		
		// Set data to mock object
		Mockito.when(assetService.getAssetById(asset.getAssetId())).thenReturn(asset);
		
		// Calling actual object
		ResponseEntity<Asset> result = assetController.getAssetById(asset.getAssetId());
		
		// Asserting
		assertEquals(result.getBody().getAssetId(), expectAsset.getAssetId());
		
	}
	
	// Test function for Update Asset
	@Test
	public void testUpdateAsset() {
		assetController = new AssetController();
		
		// Preparing Mock
		AssetService assetService = Mockito.mock(AssetServiceImpl.class);
		assetController.setAssetService(assetService);
		
		// Preparing data
		Asset expectAsset = new Asset();
		expectAsset.setAssetId(0);
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		// Set data to mock object
		Mockito.when(assetService.updateAsset(asset)).thenReturn(asset);
		
		// Calling actual method
		ResponseEntity<Asset> result = assetController.updateAsset(asset.getAssetId(), asset);
		
		// Asserting
		assertEquals(result.getBody().getAssetId(), expectAsset.getAssetId());
	}
	
	// Test function for Delete Asset
	@Test
	public void testDeleteAsset() {
		
		assetController = new AssetController();
		
		// Preparing Mock
		AssetService assetService = Mockito.mock(AssetServiceImpl.class);
		assetController.setAssetService(assetService);
		
		// Preparing data (No needed, since delete returns nothing)
		
		Asset asset = new Asset();
		asset.setAssetId(0);
		
		// Calling actual method
        assetController.deleteAsset(asset.getAssetId());
		
        // Verify if the delete method is called.
        Mockito.verify(assetService).deleteAsset(asset.getAssetId());
	}
}
