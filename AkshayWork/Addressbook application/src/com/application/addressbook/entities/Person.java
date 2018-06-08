package com.application.addressbook.entities;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class Person implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private Address address;

    public Person() {
    }

    public Person(String firstName, String lastName, Address address, String mobileNumber) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.mobileNumber = mobileNumber;
	this.address = address;
    }

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

    public String getMobileNumber() {
	return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public void editPerson(String mobileNumber, String addressLocation, String city, String state, String zipCode) {
	this.address.editAddress(addressLocation, city, state, zipCode);
	this.mobileNumber = mobileNumber;

    }

    public void displayPerson(AtomicInteger atomi) {
	String[] printData = new String[8];

	printData[0] = Integer.valueOf(atomi.incrementAndGet()).toString();
	printData[1] = this.getFirstName();
	printData[2] = this.getLastName();
	printData[3] = this.getMobileNumber();
	printData[4] = this.getAddress().getAddressLocation();
	printData[5] = this.getAddress().getCity();
	printData[6] = this.getAddress().getState();
	printData[7] = this.getAddress().getZipCode();
	String contactPersonDetails = "-------------------------------------------------"+"\n"+String.format("Index         :%20s\n"
		+ "First Name    :%20s\nLast Name     :%20s\nMobile Number :%20s\nAddress       :%20s\nCity          :%20s\nState         :%20s\nZip Code      :%20s\n",
		printData)+"\n"+"-------------------------------------------------";
	System.out.println(contactPersonDetails);

    }
}
