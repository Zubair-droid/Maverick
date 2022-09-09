package com.crud.rest.services;

import java.util.List;

import com.crud.rest.model.Asset;


public interface AssetService  {
	
	Asset createAsset(Asset asset);
	
    Asset updateAsset(Asset asset);
	
    public List <Asset> getAssets();
    
    Asset getAssetById(long id);
    
    void deleteAsset(long id);

}
