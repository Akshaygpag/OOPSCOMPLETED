package com.application.clinic.entities;

import java.io.Serializable;

/**
 * DOCTOR ENTITY WHICH IS SERIALIZABLE
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class Doctor implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String specilization;
    private String avaliable;

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

    public String getSpecilization() {
	return specilization;
    }

    public void setSpecilization(String specilization) {
	this.specilization = specilization;
    }

    public String getAvaliable() {
	return avaliable;
    }

    public void setAvaliable(String avaliable) {
	this.avaliable = avaliable;
    }

    public Doctor getDoctor(int id) {
	if (this.id == id) {
	    return this;
	}
	return null;
    }
    
    public void displayDoctor() {
	Object [] data= {Integer.valueOf(this.id).toString(),this.name,this.specilization,this.avaliable};
	String format="id : %-10s"+"\n"+"name : %-10s"+"\n"+"specialize : %-10s"+"\n"+"avaliable : %-10s";
	String doctorDetails=String.format(format, data);
	System.out.println(doctorDetails);
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	Object [] data= {Integer.valueOf(this.id).toString(),this.name,this.specilization,this.avaliable};
	String format="id : %-10s"+"\n"+"name : %-10s"+"\n"+"specialize : %-10s"+"\n"+"avaliable : %-10s";
	return String.format(format, data);
	
    }

}
