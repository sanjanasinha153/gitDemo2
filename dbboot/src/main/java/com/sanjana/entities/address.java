package com.sanjana.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Fake")
public class address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AddressId", nullable = false)
	private Long Id;
	@Column(name = "City", nullable = false)
	private String city;
	@Column(name = "Country", nullable = false)
	private String country;
	@Column(name = "Street", nullable = false)
	private String street;
	@Column(name = "Pincode", nullable = false)
	private String pinCode;
	
	public address() {
		super();
	}
	public address(Long Id, String city, String country, String street, String pinCode) {
		super();
		this.Id = Id;
		this.city = city;
		this.country = country;
		this.street = street;
		this.pinCode = pinCode;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
