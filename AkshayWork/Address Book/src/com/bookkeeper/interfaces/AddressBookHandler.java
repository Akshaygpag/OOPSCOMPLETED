package com.bookkeeper.interfaces;

import java.io.File;

import com.bookkeeper.entity.Address;
import com.bookkeeper.entity.Person;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public interface AddressBookHandler {
    int getNumberOfPersons();

    void addPerson(String firstName, String lastName, Address address, String phone);

    void updatePerson(String firstName, String lastName, String city, String address, String state, String zipCode,
	    String phone);

    String getFullNameOfPerson(int index);

    Person getPersonInformation(int index);

    void removePerson(int index);

    void sortByName();

    void sortByZip();

    void printAll();

    public void addPerson(Person person);

    boolean getChangesSinceLastSave();

    void setChangesSinceLastSave(boolean changedSinceLastSave);

}
