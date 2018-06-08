package com.application.clinic.intefaces;

import java.util.Date;

import com.application.clinic.entities.Apointment;
import com.application.clinic.entities.Clinic;
import com.application.clinic.entities.Patient;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 06-Jun-2018
 */

public interface Apointmentable {

    Apointment takeApointment(int id,Date apointmentDate,Clinic clinic,Patient patient);
    
}
