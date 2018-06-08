package com.application.clinic.intefaces;

import java.util.List;

import com.application.clinic.entities.Patient;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public interface SearchPatients {
    List<Patient> searchPatientNameWise(String name);

    List<Patient> searchPatientNumberWise(String number);

    List<Patient> searchPatientAgeWise(byte age);

    List<Patient> searchPatientIdWise(int id);

}
