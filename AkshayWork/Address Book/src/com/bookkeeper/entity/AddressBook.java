package com.bookkeeper.entity;

import java.io.File;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import com.bookkeeper.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class AddressBook {
    private static final Logger LOGGER = Logger.getLogger(AddressBook.class);

    public AddressBook() {
	BasicConfigurator.configure();
    }

    @Override
    public String toString() {
	return "AddressBook [contacts=" + contacts + ", numberOfPersons=" + numberOfPersons + ", changedSinceLastSave="
		+ changedSinceLastSave + ", file=" + file + "]";
    }

    private List<Person> contacts;
    private int numberOfPersons;
    private boolean changedSinceLastSave;
    private File file;

    public List<Person> getContacts() {

	if (this.contacts == null) {

	    this.contacts = new Vector<Person>();

	}
	return this.contacts;
    }

    public boolean getChangesSinceLastSave() {
	return changedSinceLastSave;
    }

    public void setChangesSinceLastSave(boolean changedSinceLastSave) {
	this.changedSinceLastSave = changedSinceLastSave;
    }

    public File getFile() {

	return this.file;
    }

    public void setFile(File file) {
	this.file = file;

    }

    public int getNumberOfPersons() {
	return this.contacts.size();
    }

    public void addPerson(Person person) {
	this.getContacts().add(person);
	this.changedSinceLastSave = true;
    }

    public void addPerson(String firstName, String lastName, Address address, String phone) {
	this.getContacts().add(new Person(firstName, lastName, address, phone));
	this.changedSinceLastSave = true;
    }

    public String getFullNameOfPerson(int index) {
	Person targetPerson = null;
	String fullName = null;
	index = index - 1;
	try {

	    targetPerson = this.getContacts().get(index);
	    fullName = targetPerson.getFirstName().concat(" ").concat(targetPerson.getLastName());
	} catch (Exception e) {
	    LOGGER.error("Exception at [AddressBook][getFullNameOfPerson] " + e.getMessage());
	}

	return fullName;

    }

    public Person getPersonInformation(int index) {
	index = index - 1;
	Person targetPerson = null;
	try {

	    targetPerson = this.getContacts().get(index);

	} catch (Exception e) {
	    LOGGER.error("Exception at [AddressBook][getPersonInformation] " + e.getMessage());
	}

	return targetPerson;

    }

    public void removePerson(int index) {
	index = index - 1;

	Person targetPerson = null;
	try {

	    targetPerson = this.getContacts().remove(index);
	    System.out.println("Removed person " + targetPerson);
	    this.changedSinceLastSave = true;
	} catch (NullPointerException e) {

	    LOGGER.error("Index not present ");
	    return;
	} catch (Exception e) {
	    LOGGER.error("Exception at [AddressBook][getPersonInformation] " + e.getMessage());

	}

    }

    public void sortByName() {
	Comparator<Person> sortByName = (Person firstPerson, Person secondPerson) -> {
	    String first = firstPerson.getFirstName();
	    String second = secondPerson.getFirstName();

	    if ((first.toString().toLowerCase().compareTo(second.toString().toLowerCase())) < 0) {
		return -1;

	    } else if ((first.toString().toLowerCase().compareTo(second.toString().toLowerCase())) == 0) {

		if (firstPerson.getLastName().toLowerCase().compareTo(secondPerson.getLastName().toLowerCase()) < 1) {
		    return -1;
		} else if (firstPerson.getLastName().toLowerCase()
			.compareTo(secondPerson.getLastName().toLowerCase()) == 0) {

		    return 0;

		} else {

		    return 1;

		}

	    } else {
		return 1;

	    }
	};
	this.getContacts().sort(sortByName);
    }

    public void sortByZip() {
	Comparator<Person> sortByZip = (Person first, Person second) -> {
	    Integer i1 = Integer.parseInt(first.getAddress().getZipCode());
	    Integer i2 = Integer.parseInt(second.getAddress().getZipCode());
	    if ((i1.compareTo(i2)) < 0) {
		return -1;

	    } else if ((i1.compareTo(i2)) == 0) {
		return 0;
	    } else {
		return 1;

	    }
	};
	this.getContacts().sort(sortByZip);

    }

    public void printAll() {
	AtomicInteger indexValue = new AtomicInteger(1);
	for (Person person : contacts) {

	    System.out.println(indexValue.getAndIncrement() + " " + person);

	}

    }

    public String getTitle(File fileName) {
	return this.getFile().getName();
    }

    public void updatePerson(String firstName, String lastName, String city, String address, String state,
	    String zipCode, String phone) {
	Person personToUpdate = null;
	int index = Utility.getInegerValue("Enter the index of the person to be updated");

	personToUpdate = this.getPersonInformation(index);
	Utility.printMessages(personToUpdate.toString());
	Utility.printMessages("Continue with update [true|false] ?");
	boolean proceed = Utility.getBooleanValue();

	if (!proceed) {
	    return;
	}
	Address newAddress = new Address(address, city, state, zipCode);

	personToUpdate.setAddress(newAddress);
	personToUpdate.setFirstName(firstName);

	personToUpdate.setLastName(lastName);
	personToUpdate.setPhone(phone);

	this.changedSinceLastSave = true;

    }

}
