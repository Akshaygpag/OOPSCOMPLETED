package com.application.clinic.intefaces;

import com.application.clinic.entities.Patient;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public interface ManagePatients {
    void addPatients(Patient patient);

    boolean deletePatitent(int id);
}
