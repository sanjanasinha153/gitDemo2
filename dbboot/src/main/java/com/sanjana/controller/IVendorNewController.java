package com.sanjana.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sanjana.entities.Vendor;

@RepositoryRestResource(collectionResourceRel = "test", path = "newVendor")
public interface IVendorNewController extends JpaRepository<Vendor, Long> {

}
