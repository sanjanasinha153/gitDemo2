package com.sanjana.VendorService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanjana.entities.Vendor;
@Component
public class VendorService {

	@Autowired
	IVendorPersistence vendors;
public List<Vendor> readVendors() {	
	return vendors.findAll();
	}

public Optional<Vendor> getSingleVendor(Long code){
	return vendors.findById(code) ;
}

 public Vendor createVendor(@RequestBody Vendor myvendorObj) {
	return vendors.save(myvendorObj);
}

 public List<Vendor> servcmpNm(String companyName){
	 return vendors.findByCompanyName(companyName);
 }
 
 public List<Vendor> servGst(String GstNumber) {
	return vendors.lookupGstNo(GstNumber);
}
 
public Vendor changeVendor(Vendor putVendorObj) {
	Optional<Vendor> vendMethod = vendors.findById(putVendorObj.code);
	if (!vendMethod.isPresent()) {
		return new Vendor((long)0,"","","","", "", "", "", "");
	}
	    return vendors.save(putVendorObj);
	}

public String deleteVendorById(Long vId) {
	Optional<Vendor> delVendMethod = vendors.findById(vId);
	if (!delVendMethod.isPresent()) {
		return "Id not available for deletion";
	}
		vendors.deleteById(vId);
		return "Id deleted";
}
}

 