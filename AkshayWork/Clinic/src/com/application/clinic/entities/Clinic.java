package com.application.clinic.entities;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import com.application.clinic.intefaces.ManageDoctors;
import com.application.clinic.intefaces.ManagePatients;
import com.application.clinic.util.Utility;

/**
 * CLINIC CLASS WHERE MANAGE PATIENTS AND DOCTORS AND APOINTMENTS
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class Clinic extends BaseClinic implements ManageDoctors, ManagePatients, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static Clinic clinic;
    private List<Doctor> listDoctors;
    private List<Patient> listPatients;
    private List<Apointment> listApointment;

    @Override
    public String toString() {
	return "Clinic [listDoctors=" + listDoctors + ", listPatients=" + listPatients + ", listApointment="
		+ listApointment + "]";
    }

    public Clinic() {
    }

    public static Clinic getClinic() {
	return clinic;
    }

    public static void setClinic(Clinic c) {
	clinic = c;
    }

    public List<Patient> getListPatients() {
	if (listPatients == null) {
	    this.listPatients = new Vector<Patient>();
	}
	return listPatients;
    }


    public List<Apointment> getListApointment() {
	if (listApointment == null) {
	    this.listApointment = new Vector<Apointment>();
	}
	return listApointment;
    }

    public void setListApointment(List<Apointment> listApointment) {
	this.listApointment = listApointment;
    }

    public List<Doctor> getListDoctors() {
	if (listDoctors == null) {
	    this.listDoctors = new Vector<Doctor>();
	}
	return listDoctors;
    }

    public void setListDoctors(List<Doctor> listDoctors) {
	this.listDoctors = listDoctors;
    }

    public void setListPatients(List<Patient> listPatients) {
	this.listPatients = listPatients;
    }

    /**
     * ADD PATIENT TO THE LIST OF PATIENTS
     */
    @Override
    public void addPatients(Patient patient) {
	// TAKES PATIENT OBJECT AND ADDS TO THE PATIENT LIST
	getClinic().getListPatients().add(patient);
    }

    /**
     * DELETE THE PATIENT FROM THE LIST OF PATIENTS
     */
    @Override
    public boolean deletePatitent(int id) {
	// DELETE THE PATIENT BASED ON THE ID
	Patient targetPatient = null;
	Iterator<Patient> iterate = this.getListPatients().iterator();
	while (iterate.hasNext()) {
	    targetPatient = iterate.next();
	    if (targetPatient.getId() == id) {
		this.getListPatients().remove(targetPatient);
		return true;
	    }
	}
	return false;
    }

    /**
     * ADD PATIENT TO THE LIST OF DOCTORS
     */
    @Override
    public void addDoctors(Doctor doctor) {
	// TAKES IN THE DOCTOR OBJECT AND ADDS TO THE DOCTORS LIST
	getClinic().getListDoctors().add(doctor);
    }

    public Doctor getDoctor(int id) {
	return Utility.getDoctor(id, this.getListDoctors());
    }

    public Patient getpatient(int id, List<Patient> patientList) {
	Patient patient = Utility.getPatient(id, patientList);
	return patient;
    }

}
