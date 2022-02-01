package com.sanjana.VendorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanjana.entities.address;

@Component
public class AddressService {

	@Autowired
	IAddressPersistence adps;
	
	public List<address> getAdrs() {
		return adps.findAll();
	}
	
	public address createAdrs(@RequestBody address Adrs) {
		return adps.save(Adrs);
	}
}
