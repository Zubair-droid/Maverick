package com.crud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.rest.dao.AssetService;
import com.crud.rest.model.Asset;

@RestController
public class AssetController {
   
	@Autowired
	private AssetService assetService;
	
	@GetMapping("/assets")
	public ResponseEntity <List <Asset>> getAssets(){
		return ResponseEntity.ok().body(assetService.getAssets());
	}
	
	@GetMapping("/assets/{id}")
	public ResponseEntity<Asset> getAssetById(@PathVariable long id){
		return ResponseEntity.ok().body(assetService.getAssetById(id));
	}
	
	@PostMapping("/assets")
	public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
		return ResponseEntity.ok().body(this.assetService.createAsset(asset));
	}
	
	@PutMapping("/assets/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable long id, @RequestBody Asset asset){
	    asset.setAssetId(id);
		return ResponseEntity.ok().body(this.assetService.updateAsset(asset));
	}

	@DeleteMapping("/assets/{id}")
	public HttpStatus deleteAsset(@PathVariable long id){
		this.assetService.deleteAsset(id);
		return HttpStatus.OK;
	}

	public AssetService getAssetService() {
		return assetService;
	}

	public void setAssetService(AssetService assetService) {
		this.assetService = assetService;
	}
	
	
	
}
