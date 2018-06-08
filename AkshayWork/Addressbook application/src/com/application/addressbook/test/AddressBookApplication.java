package com.application.addressbook.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.application.addressbook.entities.AddressBook;
import com.application.addressbook.interfaces.VariableHolder;
import com.application.addressbook.io.AddressBookIO;
import com.application.addressbook.manager.BookManager;
import com.application.addressbook.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class AddressBookApplication implements VariableHolder {

    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * 
     */
    static BookManager manager;

    public static void main(String... args) throws FileNotFoundException, IOException, ClassNotFoundException {
	if (manager == null) {
	    manager = new BookManager();
	}
	System.out.println("  WELCOME PAGE   ");
	System.out.println("1 manager mode");
	System.out.println("2 user mode");

	int choice = Utility.getUserInteger();
	switch (choice) {
	case 1:
	    dashBoard(manager);

	    break;

	default:

	    if (manager.getBook() == null) {

		System.out.println("Create book first");

		main();
		return;
	    }
	    dashBoard(manager.getBook());
	    break;
	}

    }

    /**
     * @param worker
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * 
     */
    @SuppressWarnings("static-access")
    private static void dashBoard(Object worker) throws FileNotFoundException, IOException, ClassNotFoundException {

	if (worker instanceof BookManager) {
	    BookManager manager = (BookManager) worker;
	    System.out.println("manager mode set");
	    while (true) {
		System.out.println();
		System.out.println();
		System.out.println("1.create new address book");
		System.out.println("2.list all address books");
		System.out.println("3.delete address  book");
		System.out.println("4.Save address books");
		System.out.println("5.Read address books");
		System.out.println("6.close address book withou saving");
		System.out.println("7.main menu");
		int managerChoice = Utility.getUserInteger();

		switch (managerChoice) {
		case 1:
		    manager.createNewAddressBook();
		    System.out.println("Created a new address book");
		    break;
		case 2:
		    Utility.displayAllFiles(manager.listAllAddressBook());
		    ;

		    break;
		case 3:
		    System.out.println("Enter the address book name to delete");
		    String bookName = Utility.getUserString();
		    manager.deleteAddressBook(bookName);
		    break;
		case 4:
		    manager.saveAddressBook(manager.getBook());
		    break;
		case 5:
		    System.out.println("Enter the address book name to read");
		    bookName = Utility.getUserString();
		    manager.readAddressbook(bookName);
		    break;
		case 6:
		    manager.closeAllAddressBooks();
		    System.out.println("Closed success");
		    break;
		default:
		    AddressBookApplication.manager.setBook(manager.getBook());
		    main();
		    break;
		}

	    }

	} else {

	    AddressBook user = (AddressBook) worker;
	    System.out.println("You are in address book : " + user.getAddressBookLocation().getName().split(".txt")[0]);
	    while (true) {
		System.out.println("1.Add person");
		System.out.println("2.remove person ");
		System.out.println("3.edit person");
		System.out.println("4.display person taking number");
		System.out.println("5.display person taking fn and ln");
		System.out.println("6.sort the address by zip code");
		System.out.println("7.sort the address by name ");
		System.out.println("8.display all persons");
		System.out.println("9.main menu");

		int userChoice = Utility.getUserInteger();
		switch (userChoice) {
		case 1:
		    user.addPerson(Utility.getPerson(true));
		    System.out.println("Person added success");
		    break;
		case 2:
		    Utility.printMessages("Phone number");
		    user.deletePerson(Utility.getUserString());
		    break;

		case 3:
		    System.out.println("Enter the index of the person in address book");
		    int index = Utility.getUserInteger();
		    user.editPersonFromAddressBook(index - 1);
		    break;
		case 4:
		    Utility.printMessages("Phone number");
		    user.displayPerson(Utility.getUserString());
		    break;
		case 5:
		    Utility.printMessages("First name and last name ");
		    user.displayPerson(Utility.getUserString(), Utility.getUserString());
		    break;
		case 6:
		    user.sortByZipCode();
		    break;
		case 7:
		    user.sortByName();
		    break;
		case 8:
		    user.displayAllPersons();
		    break;

		default:
		    if (user.getAddressBookLocation() == null) {

			user.setAddressBookLocation(new File(FILEPATH + PATHSEPERATOR + UNTITLED + EXT));

		    }
		    AddressBookApplication.manager.setBook(user);

		    main();

		    break;
		}
		// PERFORM ALL SAVE OPERATIONS AFTER THE USER MODE
		if (user.getIsChangedSinceLastSave()) {

		    ObjectMapper mapper = AddressBookIO.getObjectmapper();
		    Utility.write(mapper, user.getAddressBookLocation(), user);
		    System.out.println("Auto save complete");
		    System.out.println("\n");
		}
	    }

	}

    }

}
