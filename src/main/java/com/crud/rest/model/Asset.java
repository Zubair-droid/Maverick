package com.crud.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "assets")
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long assetId;
	
	@Column(name = "name")
	private String assetName;

	@JsonBackReference
	@ManyToOne()
	private Organization org;
	
	public Asset() {
		super();
	}
	
	public Asset(long assetId, String assetName) {
		super();
		this.assetId = assetId;
		this.assetName = assetName;
	}
	public long getAssetId() {
		return assetId;
	}
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	
	
	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetName=" + assetName + "]";
	}
	
	
	
}
