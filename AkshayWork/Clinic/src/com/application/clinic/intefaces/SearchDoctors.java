package com.application.clinic.intefaces;

import java.util.List;

import com.application.clinic.entities.Doctor;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 06-Jun-2018
 */

public interface SearchDoctors {
    List<Doctor> searchDoctorsIdWise(int id);

    List<Doctor> searchDoctorsNameWise(String name);

    List<Doctor> searchDoctorsAvailabilityWise(String availability);

    List<Doctor> searchDoctorsSpecialityWise(String speciality);

}
