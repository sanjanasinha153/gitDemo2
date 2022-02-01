package com.sanjana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanjana.VendorService.AddressService;
import com.sanjana.entities.address;

@Component
@RestController
public class AddressController {
	
	@Autowired
	AddressService adrsrv;
	
	@RequestMapping("/address")
	public List<address> getAddress() {
		return adrsrv.getAdrs();
	}
	
	@PostMapping("/address")
	public address createAddress(@RequestBody address Adrs) {
		return adrsrv.createAdrs(Adrs);
	}
	
}
