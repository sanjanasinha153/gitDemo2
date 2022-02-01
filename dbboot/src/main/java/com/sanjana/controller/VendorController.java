package com.sanjana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sanjana.VendorService.VendorService;
import com.sanjana.entities.Vendor;

@Component
@RestController
public class VendorController {
	//HashMap<String, Vendor> vendors = new HashMap<String, Vendor>();
	
//	@Autowired
//	Vendor x;
//	@Autowired
//	Vendor y;
//	@Autowired
//	Vendor z;
	@Autowired
	VendorService vS;
	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {
		//fillVendor();	
		//return vendors;
		return vS.readVendors();
	}
	
	
	  @RequestMapping("/vendor/{vendorcode}") 
	  public Vendor getVendorById(@PathVariable("vendorcode") Long code){ 
		  //fillVendor();
		  Optional<Vendor> getSingleVend = vS.getSingleVendor(code);
		  if (!getSingleVend.isPresent()) {
			return new Vendor((long)0,"","","","", "", "", "", "");
		}
			return getSingleVend.get();
	  }
	  //return vendors.get(code); return vS.getSingleVendor(code); }
	 
	
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myvendorObj) {
		/*
		 * myvendorObj.code = "newlyCreated"; return myvendorObj;
		 */
		return vS.createVendor(myvendorObj);
	}
	
	  @PutMapping("/vendor") 
	  public Vendor updateVendor(@RequestBody Vendor putVendorObj) { 
		  //return putVendorObj; 
		  return vS.changeVendor(putVendorObj);
		  
	  }
	 
	//localhost:8080/vendor/searching?company=Badmash
	@RequestMapping("/vendor/searching")
	public List<Vendor> searchByCmpNm(String company){
		return vS.servcmpNm(company);
	}
	
	//localhost:8080/vendor/looking/Tom
	@RequestMapping("/vendor/looking/{gstNo}")
	public List<Vendor> lookByGst(@PathVariable("gstNo") String gstNo){
		return vS.servGst(gstNo);
	}
	
	@DeleteMapping("/vendor/{vendorId}")
	//@RequestMapping(method=RequestMethod.DELETE, value="/vendor/{vendorId}")
	public String delVendor(@PathVariable("vendorId") Long venId) {
		return vS.deleteVendorById(venId);
	}

}
