package com.application.clinic.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class Apointment implements Serializable {
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public Apointment() {
    }

    @Override
    public String toString() {
	return String.format("Apointment set for :\nDoctor : %10s\nTime     : %10s\nDate     : %10s\n", doctor, time,
		format.format(apointmentDate).toString());

    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Doctor doctor;
    private String time;
    private Date apointmentDate;
    private Patient patient;

    /**
     * @param id
     * @param apointmentDate
     * @param clinic
     */
    public Apointment(int id, Date apointmentDate, Clinic clinic, Patient patient) {
	this.doctor = clinic.getDoctor(id);
	
	
//	System.out.println("Apointment is "+apointmentDate);
	this.apointmentDate = apointmentDate;
	this.time = clinic.getDoctor(id).getAvaliable();
	this.patient = patient;

    }

    public Date getApointmentDate() {
	
//	System.out.println("returning the apintmetn  "+apointmentDate);
	return apointmentDate;
    }

    public void setApointmentDate(Date apointmentDate) {
	this.apointmentDate = apointmentDate;
    }

    public Doctor getDoctor() {
	return doctor;
    }

    public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
    }

    public String getTime() {
	return time;
    }

    public void setTime(String time) {
	this.time = time;
    }

}
