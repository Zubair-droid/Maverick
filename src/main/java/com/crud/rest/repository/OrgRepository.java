package com.crud.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.rest.model.Organization;

public interface OrgRepository extends JpaRepository <Organization, Long> {

}
