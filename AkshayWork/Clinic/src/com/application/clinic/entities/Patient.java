package com.application.clinic.entities;

import java.io.Serializable;
import java.util.Date;

import com.application.clinic.intefaces.Apointmentable;
import com.application.clinic.util.Utility;

/**
 * PATIENT ENTITY WHICH IS SERIALIZABLE IMPLEMENTS APOINTMENTABLE
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class Patient implements Serializable, Apointmentable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    private String mobile;
    private byte age;

    private Apointment apointment;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getMobile() {
	return mobile;
    }

    public void setMobile(String mobile) {
	this.mobile = mobile;
    }

    public byte getAge() {
	return age;
    }

    public void setAge(byte age) {
	this.age = age;
    }

    public Apointment getApointment() {
	return apointment;
    }

    public void setApointment(Apointment apointment) {
	this.apointment = apointment;
    }

    /**
     * ALLOWS THE PATIENT TO TAKE APOINTMENT
     */
    public Apointment takeApointment(int id, Date apointmentDate,Clinic clinic,Patient patient) {
	// DOCTOR ID AND APOINTMENT DATE AS INPUTS FOR GETTING APOINTMENT
	Apointment apointment = null;
	Boolean available = Utility.getApointmentAvailable(id, apointmentDate);
	if (available == null) {
	    System.out.println("Invalid doctor id");
	    return null;
	}
	if (available) {
	    apointment = new Apointment(id, apointmentDate, clinic,patient);
	    clinic.getListApointment().add(apointment);
	    return apointment;
	}
	return null;
    }

    public void displaypatient() {

	Object[] data = { Integer.valueOf(this.id).toString(), this.name, this.mobile, this.age };
	String format = "id : %10s" + "\n" + "name : %10s" + "\n" + "mobile : %10s" + "\n" + "age : %10s";
	String patientDetails = String.format(format, data);
	System.out.println(patientDetails);

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

	Object[] data = { Integer.valueOf(this.id).toString(), this.name, this.mobile, this.age };
	String format = "id : %10s" + "\n" + "name : %10s" + "\n" + "mobile : %10s" + "\n" + "age : %10s";
	return String.format(format, data);

    }

 
}
