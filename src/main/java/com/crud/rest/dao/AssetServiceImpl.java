package com.crud.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.rest.exception.ResourceNotFoundException;
import com.crud.rest.model.Asset;
import com.crud.rest.repository.AssetRepository;
import com.crud.rest.repository.OrgRepository;

@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetRepository assetRepository;
	
	@SuppressWarnings("unused")
	private OrgRepository orgRepo;
	
	@Override
	public Asset createAsset(Asset asset) {
		return assetRepository.save(asset);
	}

	@Override
	public Asset updateAsset(Asset asset) {
		Optional<Asset> assetDb = this.assetRepository.findById(asset.getAssetId());
		
		if(assetDb.isPresent()) {
			Asset assetUpdate = assetDb.get();
			assetUpdate.setAssetId(asset.getAssetId());
			assetUpdate.setAssetName(asset.getAssetName());
			assetRepository.save(assetUpdate);
			return assetUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + asset.getAssetId());
		}		
	}

	@Override
	public List<Asset> getAssets() {
		return this.assetRepository.findAll();
	}

	@Override
	public Asset getAssetById(long id) {
     Optional<Asset> assetDb = this.assetRepository.findById(id);
		
		if(assetDb.isPresent()) {
			return assetDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
	}

	@Override
	public void deleteAsset(long id) {
      Optional<Asset> assetDb = this.assetRepository.findById(id);
		
		if(assetDb.isPresent()) {
			this.assetRepository.delete(assetDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : " + id);
		}
		
	}

	public AssetRepository getAssetRepository() {
		return assetRepository;
	}

	public void setAssetRepository(AssetRepository assetRepository) {
		this.assetRepository = assetRepository;
	}
	
	
}
