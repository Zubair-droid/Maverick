package com.crud.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.rest.model.Asset;

public interface AssetRepository extends JpaRepository <Asset, Long>{

}
