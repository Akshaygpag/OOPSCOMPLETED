package com.bookkeeper.entity;

import java.io.Serializable;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class Person /*implements Serializable*/ {

    @Override
    public String toString() {
	return "Person [phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
		+ "]";
    }

    /**
     * 
     */
//    private static final long serialVersionUID = 1L;

    public Person() {
    }

    public Person(String firstName, String lastName, Address address, String phone) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.phone = phone;
    }

    private String phone;
    private String firstName;
    private String lastName;
    private Address address;

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

}
