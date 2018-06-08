package com.application.clinic.intefaces;

import java.util.List;

import com.application.clinic.entities.Apointment;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 06-Jun-2018
 */

public interface PrintReport {
void printReportSpecialityWise(List<Apointment> allApointment);

void printReportDoctorWise(List<Apointment> allApointment);


}
