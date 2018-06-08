package com.application.clinic.entities;

import java.io.File;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public abstract class BaseClinic {
//    protected File storageLocation;

public static final String NAME="Fortis";
    protected static final String DOCTORRECORDS = "/home/bridgeit/CLINIC/DoctorRecords";
    protected static final String APOINTMENTSRECORDS = "/home/bridgeit/CLINIC/ApointmentRecords";
    protected static final String PATIENTRECORDS = "/home/bridgeit/CLINIC/PatientRecords";
    protected static final String PATHSEPERATOR = "/";

    protected static final String PATIENTFILE = "patients.json";
    protected static final String APOINTMENTFILE = "apoimtments.json";
    protected static final String DOCTORFILE = "doctors.json";

/*    public abstract File getStorageLocation();

    public abstract void setStorageLocation(File storageLocation);*/

//    public abstract String getName();

}
