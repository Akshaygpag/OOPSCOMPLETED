package com.application.addressbook.entities;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import com.application.addressbook.interfaces.VariableHolder;
import com.application.addressbook.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class AddressBook implements Serializable, VariableHolder {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<Person> contactList = new Vector<Person>();
    private File addressBookLocation;
    private Boolean isChangedSinceLastSave;
    private String addressBookName;

    public String getAddressBookName() {
	this.addressBookName = addressBookLocation.getName().split(EXT)[0];
	return addressBookLocation.getName().split(EXT)[0];
    }

    public void setAddressBookName(String addressBookName) {
	this.addressBookName = addressBookName;
    }

    public AddressBook() {
    }

    public List<Person> getContactList() {
	return contactList;
    }

    public void setContactList(Vector<Person> contactList) {
	this.contactList = contactList;
    }

    public File getAddressBookLocation() {
	return addressBookLocation;
    }

    public void setAddressBookLocation(File addressBookLocation) {
	this.addressBookLocation = addressBookLocation;
    }

    public Boolean getIsChangedSinceLastSave() {
	return isChangedSinceLastSave;
    }

    public void setIsChangedSinceLastSave(Boolean isChangedSinceLastSave) {
	this.isChangedSinceLastSave = isChangedSinceLastSave;
    }

    public void addPerson(Person person) {
	this.contactList.add(person);
    }

    public void editPerson(Person person, int index) {

	Person existingPerson = this.contactList.get(index);

	if (existingPerson == null) {
	    System.out.println("Person not in the address book");
	    return;
	}
	existingPerson.editPerson(person.getMobileNumber(), person.getAddress().getAddressLocation(),
		person.getAddress().getCity(), person.getAddress().getState(), person.getAddress().getZipCode());
	this.setIsChangedSinceLastSave(true);
	System.out.println("Person updated success .");
    }

    public void deletePerson(String number) {
	Person person = Utility.matchNumber(number, this.contactList);
	if (person != null) {
	    this.contactList.remove(person);
	    this.setIsChangedSinceLastSave(true);
	    return;
	}
	System.out.println("Person not in the address book");
    }

    public void displayAllPersons() {
	this.setIsChangedSinceLastSave(false);

	AtomicInteger atomi = new AtomicInteger(0);
	Iterator<Person> iterate = null;
	if (contactList.size() == 0) {

	    System.out.println("No entries found....");
	}
	iterate = contactList.iterator();
	while (iterate.hasNext()) {
	    Person temp = iterate.next();
	    temp.displayPerson(atomi);
	}
    }

    public void displayPerson(String number) {
	this.setIsChangedSinceLastSave(false);
	AtomicInteger atomi = new AtomicInteger(0);
	Iterator<Person> iterate = null;
	iterate = contactList.iterator();
	while (iterate.hasNext()) {
	    Person temp = iterate.next();
	    if (temp.getMobileNumber().equals(number)) {
		temp.displayPerson(atomi);
	    }
	}
    }

    public void setContactList(List<Person> contactList) {
	this.contactList = contactList;
    }

    public void displayPerson(String firstName, String lastName) {
	this.setIsChangedSinceLastSave(false);

	AtomicInteger atomi = new AtomicInteger(0);
	Person person = new Person();
	person.setFirstName(firstName);
	person.setLastName(lastName);
	Person displayPerson = Utility.matchPerson(person, contactList);
	displayPerson.displayPerson(atomi);
    }

    public void sortByZipCode() {

	Comparator<Person> sortZipCode = (Person first, Person second) -> {

	    if ((first.getAddress().getZipCode().compareTo(second.getAddress().getZipCode())) == 0) {

		if ((first.getFirstName().compareTo(second.getFirstName())) < 0) {
		    return -1;
		} else if ((first.getFirstName().compareTo(second.getFirstName())) > 0) {
		    return 1;
		} else {
		    return 0;
		}

	    } else if ((first.getAddress().getZipCode().compareTo(second.getAddress().getZipCode())) < 0) {
		return -1;
	    }
	    return 1;

	};
	if (this.contactList.size() > 0) {

	    this.contactList.sort(sortZipCode);
	    this.setIsChangedSinceLastSave(true);
	    System.out.println("Sorted by zip code");
	    return;
	}
	System.out.println("No entries found ...");
    }

    public void sortByName() {

	Comparator<Person> sortName = (Person first, Person second) -> {

	    if ((first.getFirstName().compareTo(second.getFirstName())) < 0) {
		return -1;
	    } else if ((first.getFirstName().compareTo(second.getFirstName())) == 0) {
		if ((first.getLastName().compareTo(second.getLastName())) < 0) {

		    return -1;
		} else if ((first.getLastName().compareTo(second.getLastName())) > 0) {

		    return 1;
		} else {
		    return 0;
		}

	    } else
		return 1;

	};
	if (this.contactList.size() > 0) {
	    this.contactList.sort(sortName);
	    this.setIsChangedSinceLastSave(true);
	    System.out.println("Sorted by name");
	    return;
	}
	System.out.println("No entries found ...");

    }

    /**
     * @param i
     * 
     */
    public void editPersonFromAddressBook(int index) {
	try {
	    
	    Person existingPerson = this.contactList.get(index);

		if (existingPerson == null) {
		    System.out.println("Person not in the address book");
		    return;
		}
		existingPerson.displayPerson(new AtomicInteger(index));

		System.out.println("Enter the field to change");
		String choice = Utility.getUserString().toLowerCase();
		String field = null;
		System.out.println("Enter the field value");
		String value = Utility.getUserString();
		switch (choice) {
		case "mobile number":
		    field = "mobile number";
		    existingPerson.setMobileNumber(value);
		    break;
		case "address":
		    field = "address location";
		    existingPerson.getAddress().setAddressLocation(value);
		    break;
		case "city":
		    field = "city";
		    existingPerson.getAddress().setCity(value);
		    break;
		case "state":
		    field = "state";
		    existingPerson.getAddress().setState(value);
		    break;
		case "zip code":
		    existingPerson.getAddress().setZipCode(value);
		    field = "zip code";
		    break;

		default:
		    break;
		}

		System.out.println("Editing " + field);
		this.setIsChangedSinceLastSave(true);
		System.out.println("Person updated success .");

	    
	}catch(Exception e) {
	    
	    System.out.println("No entries found ...");
	    return;
	}
    }
}
