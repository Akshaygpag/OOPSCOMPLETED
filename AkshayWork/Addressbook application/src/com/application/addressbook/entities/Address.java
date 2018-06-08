package com.application.addressbook.entities;

import java.io.Serializable;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class Address implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String addressLocation;
    private String city;
    private String state;
    private String zipCode;
public Address() {}
    public Address(String addressLocation, String city, String state, String zipCode) {
	super();
	this.addressLocation = addressLocation;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
    }

    public String getAddressLocation() {
	return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
	this.addressLocation = addressLocation;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    public void editAddress(String addressLocation, String city, String state, String zipCode) {
	this.setAddressLocation(addressLocation);
	this.setCity(city);
	this.setState(state);
	this.setZipCode(zipCode);
    }

}
