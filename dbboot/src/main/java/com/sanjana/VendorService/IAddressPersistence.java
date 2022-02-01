package com.sanjana.VendorService;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjana.entities.address;

public interface IAddressPersistence extends JpaRepository<address, Long> {

}
