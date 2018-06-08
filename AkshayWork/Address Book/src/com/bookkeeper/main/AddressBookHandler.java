package com.bookkeeper.main;

import org.apache.log4j.Logger;

import com.bookkeeper.entity.Address;
import com.bookkeeper.entity.AddressBook;
import com.bookkeeper.entity.Person;
import com.bookkeeper.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class AddressBookHandler {
    private static final Logger LOGGER = Logger.getLogger(AddressBookHandler.class);

    public void addPersonWrapper(AddressBook addressBook) {

	try {

	    Person person = Utility.getPerson();
	    addressBook.addPerson(person);
	    Utility.printMessages("Person added success");

	} catch (Exception e) {
	    LOGGER.error("Exception at  [AddressBookHandler][addPersonWrapper]");
	    Utility.printMessages(e.getMessage());

	}
    }

    public void deletePersonWrapper(AddressBook addressBook) {

	try {
	    int index = Utility.getInegerValue("Enter the index of person");
	    addressBook.removePerson(index);
	    Utility.printMessages("Person removed success");
	} catch (Exception e) {

	    LOGGER.error("Exception at  [AddressBookHandler][deletePersonWrapper]");
	    Utility.printMessages(e.getMessage());

	}
    }

    public void updatePersonWrapper(AddressBook addressBook) {

	Person updatePerson = null;
	Address updateAddress = null;
	try {

	    updatePerson = Utility.getPerson();
	    updateAddress = updatePerson.getAddress();
	    addressBook.updatePerson(updatePerson.getFirstName(), updatePerson.getLastName(), updateAddress.getCity(),
		    updateAddress.getAddress(), updateAddress.getState(), updateAddress.getZipCode(),
		    updatePerson.getPhone());

	} catch (Exception e) {

	    LOGGER.error("Exception at  [AddressBookHandler][updatePerson]");
	    Utility.printMessages(e.getMessage());

	}

    }

    public int countPersonsInAddressBookWrapper(AddressBook addressBook) {

	return addressBook.getContacts().size();

    }

    public Person getPersonWrapper(AddressBook addressBook) {

	int index = Utility.getInegerValue("Enter the index of the person in address book");

	return addressBook.getPersonInformation(index);

    }

    public String getFullNameWrapper(AddressBook addressBook) {

	int index = Utility.getInegerValue("Enter the index of the person in address book");

	return addressBook.getFullNameOfPerson(index);

    }

}
