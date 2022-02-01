package com.sanjana.entities;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Test")
public class Vendor {
	@Id
	@Column(nullable = false, name="CodeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long code;
	
	@Column(nullable = false, name="CompanyName")
	public String companyName;
	
	@Column(nullable = false, name="ContactName")
	public String contactName;
	
	@Column(nullable = false, name="LastName")
	public String lastName;
	
	@Column(nullable = false, name="FirstName")
	public String firstName;
	
	@Column(nullable = false, name="Website")
	public String website;
	
	@Column(nullable = false, name="Email")
	public String email;
	
	@Column(nullable = false, name="Status")
	public String status;
	
	@Column(nullable = false, name="RegDate")
	public String regDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "Vendor", referencedColumnName = "CodeId")
	private List<address> adr = new ArrayList<>();

	public Vendor() {
		
	}
	public Vendor(Long code, String companyName, String contactName, String lastName, String firstName, String website,
			String email, String status, String regDate) {
		super();
		this.code = code;
		this.companyName = companyName;
		this.contactName = contactName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.website = website;
		this.email = email;
		this.status = status;
		this.regDate = regDate;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public List<address> getAdr() {
		return adr;
	}
	public void setAdr(List<address> adr) {
		this.adr = adr;
	}
	
	
}
