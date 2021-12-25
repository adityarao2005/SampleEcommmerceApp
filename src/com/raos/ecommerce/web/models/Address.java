package com.raos.ecommerce.web.models;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "addresses")
@NamedQuery(name = "Address.findAll", query = "from Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String city;

	@Column(name = "is_default")
	private boolean defaultAddress;

	private String state;

	private String street;
	private String country;

	@Column(name = "street_no")
	private int streetNo;

	private String zip;

	public Address() {
	}

	public Address(String city, String state, String street, String country, int streetNo, String zip) {
		super();
		this.city = city;
		this.state = state;
		this.street = street;
		this.country = country;
		this.streetNo = streetNo;
		this.zip = zip;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isDefaultAddress() {
		return this.defaultAddress;
	}

	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNo() {
		return this.streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return String.format("%d %s, %s %s %s, %s", streetNo, street, city, state, country, zip);
	}
}