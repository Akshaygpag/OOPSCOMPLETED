package com.bookkeeper.entity;

import java.io.Serializable;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class Address implements Serializable {
    @Override
    public String toString() {
	return "Address [address=" + address + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String address;
    private String city;

    public Address() {
    }

    public Address(String address, String city, String state, String zipCode) {
	super();
	this.address = address;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
    }

    private String state;
    private String zipCode;

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
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
}
