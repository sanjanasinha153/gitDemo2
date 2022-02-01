package com.sanjana.VendorService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanjana.entities.Vendor;


public interface IVendorPersistence extends JpaRepository<Vendor, Long> {
	List<Vendor> findByCompanyName(String companyNametest);
	@Query(nativeQuery = true, value = "select * from test where lower(reg_date) like %?1%")
	List<Vendor> lookupGstNo(String gstNotest);
}
