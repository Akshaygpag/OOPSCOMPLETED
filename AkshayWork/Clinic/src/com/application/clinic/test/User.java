package com.application.clinic.test;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.application.clinic.entities.Apointment;
import com.application.clinic.entities.BaseClinic;
import com.application.clinic.entities.Clinic;
import com.application.clinic.entities.Doctor;
import com.application.clinic.entities.Patient;
import com.application.clinic.intefaces.PrintReport;
import com.application.clinic.intefaces.SearchDoctors;
import com.application.clinic.intefaces.SearchPatients;
import com.application.clinic.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

@SuppressWarnings("serial")
public class User extends Clinic implements PrintReport, SearchDoctors, SearchPatients {

    public static void main(String[] args) throws ParseException {
	User user = new User();
	ClassLoader loader = ClassLoader.getSystemClassLoader();
	try {
	    loader.loadClass(Utility.class.getName());
	} catch (ClassNotFoundException e) {

	    System.out.println("Exception found here");

	}

	if (user.retreiveValues() == null) {

	    Clinic.setClinic(new Clinic());

	} else {
	    Clinic.setClinic(user.retreiveValues());

	}

	System.out.println("--------------------------Welcome to " + BaseClinic.NAME + "---------------------");
	while (true) {
	    System.out.println("1.add doctor");
	    System.out.println("2.create apointment ");
	    System.out.println("3.add patient");
	    System.out.println("4.print report doctor wise");
	    System.out.println("5.print report special wise");
	    System.out.println("6.Search patients ");
	    System.out.println("7.search doctors");
	    System.out.println("8.exit");
	    int choice = Utility.getUserInt();

	    int pId = -1;
	    Patient patient = null;
	    switch (choice) {
	    case 1:
		user.addDoctors(Utility.getDoctor());
		System.out.println("doctor added success ");
		break;
	    case 2:
		System.out.println("Enter the patient id");
		pId = Utility.getUserInt();
		Clinic.getClinic().setListDoctors(Clinic.getClinic().getListDoctors());
		patient = user.getpatient(pId, Clinic.getClinic().getListPatients());
		if (patient != null) {
		    System.out.println("displaying the patient");
		    patient.displaypatient();
		    Apointment apointment = user.getApointment(patient, new Date());
		    System.out.println(apointment);
		    Clinic.getClinic().setListApointment(Clinic.getClinic().getListApointment());
		    patient.setApointment(apointment);
		} else {
		    System.out.println("No patient found");
		}

		break;
	    case 3:
		Patient p = Utility.getPatient();
		user.addPatients(p);
		p.displaypatient();
		System.out.println("Patient added success ");
		break;

	    case 4:
		user.printReportDoctorWise(Clinic.getClinic().getListApointment());

		break;
	    case 5:
		/*
		 * System.out.println(Clinic.getClinic().getListApointment());
		 * System.out.println(); System.exit(1);
		 */
		user.printReportSpecialityWise(Clinic.getClinic().getListApointment());
		break;
	    case 6:
		List<Patient> patientList = user.searchpatients();
		if (patientList == null) {
		    System.out.println("No patients available");
		    break;
		}
		Utility.printList(patientList);
		break;
	    case 7:
		List<Doctor> doctorList = user.searchDoctors();
		if (doctorList == null) {
		    System.out.println("No doctors available");
		    break;
		}
		Utility.printList(doctorList);

		break;
	    default:
		saveAllData();
		saveGenerators();

		System.out.println("Exiting.");
		System.exit(1);
	    }
	}

    }

    /**
     * 
     * 
     */
    private static void saveGenerators() {
	Utility.saveGeneratedValues();

    }

    /**
     * @param clinic
     * 
     */
    private Clinic retreiveValues() {
	ObjectMapper mapper = new ObjectMapper();
	Clinic ref = null;
	try {
	    ref = mapper.readValue(new File("/home/bridgeit/CLINIC/" + "clinic.json"), Clinic.class);
	    for (Doctor doctor : ref.getListDoctors()) {
		doctor.setId(Utility.iDDocGenerator.incrementAndGet());
	    }
	    for (Patient patient : ref.getListPatients()) {
		patient.setId(Utility.iDPatGenerator.incrementAndGet());
	    }

	} catch (EOFException e) {
	    return ref;
	} catch (JsonParseException e) {
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return ref;
    }

    /**
     * 
     * 
     */
    private static void saveAllData() {
	Utility.writeToFile(Clinic.getClinic(), Clinic.class);
    }

    /**
     * SEARCHES THE DOCTORS BASED ON THE CHOICE OF THE USER
     * 
     * @return
     * 
     * 
     */
    private List<Doctor> searchDoctors() {
	// SEARCHES THE DOCTORS BASED ON THE CONSTRAINT SELECTED
	int choice = 0;
	System.out.println("1.Search by specilization");
	System.out.println("2.Search by Name");
	System.out.println("3.Search by id");
	System.out.println("4.Search by Availability");
	System.out.println("5.Back");

	choice = Utility.getUserInt();
	switch (choice) {
	case 1:
	    System.out.println("Enter the speciality of the doctor");
	    String speciality = Utility.getUserString();
	    return this.searchDoctorsSpecialityWise(speciality);
	case 2:
	    System.out.println("Enter the name of the doctor");
	    String name = Utility.getUserString();
	    return this.searchDoctorsNameWise(name);

	case 3:
	    System.out.println("Enter the id of the doctor");
	    int id = Utility.getUserInt();
	    return this.searchDoctorsIdWise(id);
	case 4:
	    System.out.println("Enter the available of the doctor");
	    String avail = Utility.getUserString();
	    return this.searchDoctorsAvailabilityWise(avail);

	default:
	    return null;
	}
    }

    /**
     * SEARCHES THE PATIENTS IN THE SYSTEM
     * 
     * @return
     * 
     * 
     */
    private List<Patient> searchpatients() {
	// SEARCHES THE PATIENTS BASED ON THE CHOICE OF THE USER
	int choice = 0;
	System.out.println("1.Search by number");
	System.out.println("2.Search by Name");
	System.out.println("3.Search by id");
	System.out.println("4.Search by age");
	System.out.println("5.Back");

	choice = Utility.getUserInt();
	switch (choice) {
	case 1:
	    System.out.println("Enter the number of the patient");
	    String number = Utility.getUserString();
	    return this.searchPatientNumberWise(number);
	case 2:
	    System.out.println("Enter the name of the patient");
	    String name = Utility.getUserString();
	    return this.searchPatientNameWise(name);

	case 3:
	    System.out.println("Enter the id of the patient");
	    int id = Utility.getUserInt();
	    return this.searchPatientIdWise(id);

	case 4:
	    System.out.println("Enter the age of the patient");
	    byte age = Utility.getUserByte();
	    return this.searchPatientAgeWise(age);

	default:
	    System.out.println("No choice selected");
	    return null;
	}
    }

    /**
     * GETS THE APOINTMENT FOR THE PATIENT
     * 
     * @param patient
     * @param date
     * @throws ParseException
     * 
     */
    private Apointment getApointment(Patient patient, Date date) throws ParseException {
	System.out.println("Enter the doctor id");
	int dId = Utility.getUserInt();
	Apointment myApointment = null;
	int increment = 0;
	Date convertedDate = Utility.convertDateFormat(date, increment);
	while (myApointment == null) {
	    myApointment = patient.takeApointment(dId, convertedDate, Clinic.getClinic(), patient);
	    convertedDate = Utility.convertDateFormat(convertedDate, 1);
	}
	return myApointment;
    }

    /**
     * SEARCH PATIENT NAME WISE
     */
    @Override
    public List<Patient> searchPatientNameWise(String name) {
	// NAME BASED SEARCHES

	List<Patient> patientList = new Vector<Patient>();
	Iterator<Patient> iterator = Clinic.getClinic().getListPatients().iterator();

	while (iterator.hasNext()) {

	    Patient patient = iterator.next();
	    if (patient.getName().equalsIgnoreCase(name)) {
		patientList.add(patient);

	    }

	}

	return patientList;
    }

    /**
     * SEARCH PATIENT NUMBER WISE
     */
    @Override
    public List<Patient> searchPatientNumberWise(String number) {
	// MOBILE NUMBER BASED SEARCHES
	List<Patient> patientList = new Vector<Patient>();
	Iterator<Patient> iterator = Clinic.getClinic().getListPatients().iterator();
	while (iterator.hasNext()) {
	    Patient patient = iterator.next();
	    if (patient.getMobile().equalsIgnoreCase(number)) {
		patientList.add(patient);
	    }
	}
	return patientList;
    }

    /**
     * SEARCH PATIENT AGE WISE
     */
    @Override
    public List<Patient> searchPatientAgeWise(byte age) {
	List<Patient> patientList = new Vector<Patient>();
	Iterator<Patient> iterator = Clinic.getClinic().getListPatients().iterator();

	while (iterator.hasNext()) {

	    Patient patient = iterator.next();
	    if (patient.getAge() == age) {
		patientList.add(patient);

	    }

	}

	return patientList;
    }

    /**
     * SEARCH PATIENT ID WISE
     */
    @Override
    public List<Patient> searchPatientIdWise(int id) {
	List<Patient> patientList = new Vector<Patient>();
	Iterator<Patient> iterator = Clinic.getClinic().getListPatients().iterator();

	while (iterator.hasNext()) {

	    Patient patient = iterator.next();
	    if (patient.getId() == id) {
		patientList.add(patient);

	    }

	}

	return patientList;
    }

    /**
     * SEARCH DOCTOR ID WISE
     */
    @Override
    public List<Doctor> searchDoctorsIdWise(int id) {
	List<Doctor> doctorList = new Vector<Doctor>();
	Iterator<Doctor> iterator = Clinic.getClinic().getListDoctors().iterator();
	while (iterator.hasNext()) {
	    Doctor doctor = iterator.next();
	    if (doctor.getId() == id) {
		doctorList.add(doctor);
	    }
	}
	return doctorList;
    }

    /**
     * SEARCH DOCTOR NAME WISE
     */
    @Override
    public List<Doctor> searchDoctorsNameWise(String name) {
	List<Doctor> doctorList = new Vector<Doctor>();
	Iterator<Doctor> iterator = Clinic.getClinic().getListDoctors().iterator();

	while (iterator.hasNext()) {

	    Doctor doctor = iterator.next();
	    if (doctor.getName().equalsIgnoreCase(name)) {
		doctorList.add(doctor);

	    }

	}

	return doctorList;
    }

    /**
     * SEARCH DOCTOR AVAILABLE WISE
     */
    @Override
    public List<Doctor> searchDoctorsAvailabilityWise(String availability) {
	List<Doctor> doctorList = new Vector<Doctor>();
	Iterator<Doctor> iterator = Clinic.getClinic().getListDoctors().iterator();

	while (iterator.hasNext()) {

	    Doctor doctor = iterator.next();
	    if (doctor.getAvaliable().equalsIgnoreCase(availability)) {
		doctorList.add(doctor);
	    }
	}
	return doctorList;
    }

    /**
     * SEARCH DOCTOR SPECIALITY WISE
     */
    @Override
    public List<Doctor> searchDoctorsSpecialityWise(String speciality) {
	List<Doctor> doctorList = new Vector<Doctor>();
	Iterator<Doctor> iterator = Clinic.getClinic().getListDoctors().iterator();

	while (iterator.hasNext()) {

	    Doctor doctor = iterator.next();
	    if (doctor.getSpecilization().equalsIgnoreCase(speciality)) {
		doctorList.add(doctor);

	    }

	}

	return doctorList;
    }

    /**
     * PRINT REPORT SPECIALITY WISE
     */
    @Override
    public void printReportSpecialityWise(List<Apointment> allApointment) {
	if (allApointment.size() > 0) {

	    Comparator<Apointment> speciality = (Apointment one, Apointment two) -> {
		if ((one.getDoctor().getSpecilization().compareTo(two.getDoctor().getSpecilization())) < 0) {

		    return -1;
		} else if ((one.getDoctor().getSpecilization().compareTo(two.getDoctor().getSpecilization())) == 0) {
		    return 0;
		}
		return 1;
	    };
	    allApointment.sort(speciality);

	    String firstValue = allApointment.get(0).getDoctor().getSpecilization();
	    Map<String, Integer> report = new HashMap<String, Integer>();
	    int counter = 0;
	    int secondCounter = 0;

	    for (int i = 0; i < allApointment.size(); i++) {
		if (allApointment.get(i).getDoctor().getSpecilization().equalsIgnoreCase(firstValue)) {
		    counter++;
		} else {
		    Doctor doctor = null;
		    secondCounter = counter;
		    counter = 1;
		    doctor = allApointment.get(i - 1).getDoctor();
		    report.put(doctor.getSpecilization(), secondCounter);
		    firstValue=allApointment.get(i).getDoctor().getSpecilization();
		    
		}
	    }
	    
	    System.out.println(allApointment);

	    Doctor doctor = null;
	    doctor = allApointment.get(allApointment.size()-1).getDoctor();
	    report.put(doctor.getSpecilization(), counter);

	    Iterator<String> it = report.keySet().iterator();
	    System.out.println();
	    System.out.println();
	    System.out.println();

	    System.out.println("			 REPORT		 ");
	    System.out.println(String.format("%20s  ", "NAME") + "  		  "+"PATIENTS"+"  ");
	    System.out.println("---------------------------------------------------------");
	    int totalCount=0;
	    while (it.hasNext()) {
		String name = it.next();
		totalCount+=report.get(name);
		System.out.println(String.format("%20s :", name) + "  		 "+report.get(name)+"  ");
	    }

	    Set<String> special = clinic.getClinic().getListDoctors().stream().map(p -> {
		return p.getSpecilization();
	    }).collect(Collectors.toSet());

	    Set<String> remaindes = special.stream().filter(p -> {
		if (report.keySet().contains(p)) {

		    return false;
		}
		return true;

	    }).collect(Collectors.toSet());
	    remaindes.forEach(p -> {

		System.out.println(String.format("%20s :", p) + "    		 0  ");

	    });
	    System.out.println("---------------------------------------------------------");
	    System.out.println(String.format("%20s :", "Total") + "    		 "+totalCount+"  ");
	    System.out.println("-------------------------END-----------------------------");

	}

    }

    /**
     * PRINT REPORT DOCTOR WISE
     */
    @Override
    public void printReportDoctorWise(List<Apointment> allApointment) {
	if (allApointment.size() > 0) {
	    Comparator<Apointment> doctorWise = (Apointment one, Apointment two) -> {
		if ((one.getDoctor().getName().compareTo(two.getDoctor().getName())) < 0) {

		    return -1;
		} else if ((one.getDoctor().getName().compareTo(two.getDoctor().getName())) == 0) {
		    return 0;
		}
		return 1;
	    };
	    allApointment.sort(doctorWise);
	    String firstValue = allApointment.get(0).getDoctor().getName();
	    Map<String, Integer> report = new HashMap<String, Integer>();
//	    int start = 0;
	    int counter = 0;
	    int secondCounter = 0;
	    for (int i = 0; i < allApointment.size(); i++) {
//		start = i;
		if (allApointment.get(i).getDoctor().getName().equalsIgnoreCase(firstValue)) {
		    counter++;
		} else {
		    Doctor doctor = null;
		    secondCounter = counter;
		    counter = 1;
		    doctor = allApointment.get(i - 1).getDoctor();
		    report.put(doctor.getName(), secondCounter);
		    firstValue=allApointment.get(i).getDoctor().getName();
		}
	    }

	    Doctor doctor = null;
	    doctor = allApointment.get(allApointment.size()-1).getDoctor();
	    report.put(doctor.getName(), counter);

	    Iterator<String> it = report.keySet().iterator();
	    System.out.println();
	    System.out.println();
	    System.out.println();

	    System.out.println("			 REPORT		 ");
	    System.out.println(String.format("%20s  ", "SPEC") + "   		 "+"PATIENTS"+"  ");
	    System.out.println("---------------------------------------------------------");
	    int totalCount=0;
	    while (it.hasNext()) {
		String name = it.next();
		totalCount+=report.get(name);
		System.out.println(String.format("%20s :", name) + "  		 "+report.get(name)+"  ");
	    }
	    Set<String> special = clinic.getClinic().getListDoctors().stream().map(p -> {
		return p.getName();
	    }).collect(Collectors.toSet());

	    Set<String> remaindes = special.stream().filter(p -> {
		if (report.keySet().contains(p)) {

		    return false;
		}
		return true;

	    }).collect(Collectors.toSet());
	    remaindes.forEach(p -> {

		System.out.println(String.format("%20s :", p) + "    		 0  ");

	    });
	    System.out.println("---------------------------------------------------------");
	    System.out.println(String.format("%20s :", "Total") + "    		 "+totalCount+"  ");
	    System.out.println("-------------------------END-----------------------------");
	    return;
	}
	System.out.println("Empty report...");
    }
}
