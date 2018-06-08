/*package com.application.clinic.util;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.application.clinic.entities.Apointment;
import com.application.clinic.entities.Clinic;
import com.application.clinic.entities.Doctor;
import com.application.clinic.entities.Patient;
import com.application.clinic.intefaces.Common;

*//**
 * @author Akshay
 * @version 1.0.0
 * @since 06-Jun-2018
 *//*

public class Utility implements Common {
    static final AtomicInteger iDDocGenerator = new AtomicInteger(101);
    static final AtomicInteger iDPatGenerator = new AtomicInteger(1001);
    static ObjectMapper mapper = new ObjectMapper();

    static final Scanner scanner = new Scanner(System.in);
    static SimpleDateFormat simpleFormat = new SimpleDateFormat(DDMMYYYY);
    static Calendar calendar = Calendar.getInstance();

    *//**
     * CHECK FOR THE AVAILABLE APOINTMENT
     * 
     * @param id
     * @param apointmentDate
     * @return
     * 
     *//*
    public static Boolean getApointmentAvailable(int id, Date apointmentDate) {
	// DATE OBJECT FOR THE APOINTMENT AND ID OF THE DOCTOR
	List<Doctor> listDoctors = Clinic.getThisclinic().getListDoctors();

	Doctor currentDoctor = Utility.getDoctor(id, listDoctors);

	Iterator<Apointment> iterator = Clinic.getThisclinic().getListApointment().iterator();
	int countApointment = 0;
	while (iterator.hasNext()) {

	    Apointment apointment = iterator.next();
	    if (apointment.getDoctor() == currentDoctor && apointment.getApointmentDate().equals(apointmentDate)) {
		countApointment++;
	    }
	}

	if (countApointment < Common.LIMIT) {
	    return true;
	}
	return false;
    }

    *//**
     * ITERATES THROUGH THE DOCTORS LIST AND RETURNS THE DOCTOR WHOSE ID MATCHES
     * 
     * @param id
     * @param listDoctors
     * @return
     * 
     *//*
    public static Doctor getDoctor(int id, List<Doctor> listDoctors) {
	// ID FOR SEARCH DOCTOR

	System.out.println("Stating the size of the array lsit " + listDoctors.size());
	for (Doctor doctor : listDoctors) {
	    if (doctor.getId() == id) {
		System.out.println("found doctro returning");
		return doctor;
	    }
	}
	return null;
    }

    *//**
     * 
     * 
     *//*
    public static String getUserString() {
	// USER INPUT FOR STIRNG
	return scanner.nextLine();
    }

    *//**
     * @return
     * 
     * 
     *//*
    public static int getUserInt() {
	int data = scanner.nextInt();
	scanner.nextLine();
	return data;
    }

    *//**
     * @return
     * 
     *//*
    public static Doctor getDoctor() {
	Doctor doctor = new Doctor();
	doctor.setId(iDDocGenerator.getAndIncrement());
	System.out.println("Enter doctor name");
	doctor.setName(getUserString());
	System.out.println("Enter doctor special");
	doctor.setSpecilization(getUserString());
	System.out.println("Enter doctor avail");
	doctor.setAvaliable(getUserString());
	return doctor;
    }

    public static Patient getPatient(int id, List<Patient> listpatients) {
	for (Patient patientSingle : listpatients) {
	    if (patientSingle.getId() == id) {
		return patientSingle;
	    }
	}
	return null;
    }

    *//**
     * @param date
     * @return
     * @throws ParseException
     * 
     *//*
    public static Date convertDateFormat(Date date, int increment) throws ParseException {
	// System.out.println("ERROR");
	calendar.setTime(date);

	calendar.add(calendar.get(Calendar.DATE), increment);

	String dateFormatted = simpleFormat.format(calendar.getTime());

	// System.out.println(dateFormatted);

	// System.out.println(calendar.getTime());

	return simpleFormat.parse(dateFormatted);

    }

    *//**
     * @return
     * 
     *//*
    public static Patient getPatient() {
	Patient patient = new Patient();
	patient.setId(iDPatGenerator.getAndIncrement());
	patient.setApointment(null);
	System.out.println("Enter the patient name");
	patient.setName(getUserString());
	System.out.println("Enter the patient mobile number");
	patient.setMobile(getUserString());
	System.out.println("Enter the patient age");
	patient.setAge(getUserByte());
	return patient;
    }

    *//**
     * @return
     * 
     *//*
    public static byte getUserByte() {
	byte data = scanner.nextByte();
	scanner.nextLine();
	return data;
    }

    *//**
     * @param patientList
     * 
     *//*
    public static <T> void printList(List<T> List) {
	for (T element : List) {
	    System.out.println(element);
	}

    }

    *//**
     * @param listApointment
     * @param class1
     * @param apointmentFile
     * 
     *//*
    public static <T> void writeToFile(List<T> list, Class<T> className, File ile) {

	
	
	mapper.writeValue(file, value);
	
	
	
    }



}
*/