package com.bookkeeper.main;

import java.io.File;
import java.util.Arrays;

import org.apache.log4j.Logger;
import com.bookkeeper.entity.AddressBook;
import com.bookkeeper.entity.FileSystem;
import com.bookkeeper.entity.Person;
import com.bookkeeper.manager.AddressBookManager;
import com.bookkeeper.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class AddressBookApplication {
    private static final String WELCOME_MESSAGE = "Welcome ADMIN \nEnter your choice \n1.ADDRESS BOOK MANAGER \n2.ADDRESS BOOK USAGE\n";
    private static final String MANAGER_METHODS = "Welcome MANAGER MODE \nEnter your choice \n1.Create Address Book \n2.Delete Address Book by name\n3.Save Address Book \n4.List all Address Books \n5.Rename the address book \n6.Get  Address Book \n7.Back to Main menu";
    private static final String HANDLER_METHODS = "Welcome USER MODE \nEnter your choice \n1.Add Person \n2.Update Person \n3.Remove Person \n4.Number of Persons \n5.Get Full Name of Person \n6.Get Person \n7.Back to Main menu";
    private static final String EXT = ".json";

    static AddressBook addressBook = null;
    private static final String ERROR = "Wrong choice selected";
    private static final Logger LOGGER = Logger.getLogger(AddressBookApplication.class);
    private static final String FILE_PATH = "/home/bridgeit/addressbookkeeper/";

    public static void main(String... args) {
	dashBoard();
    }

    /**
     * 
     * 
     */
    private static void dashBoard(int... choiceArray) {
	int choice = 0;
	if (choiceArray.length == 0) {

	    choice = Utility.getInegerValue(WELCOME_MESSAGE);

	}
	else {
	    
	    choice = choiceArray[0];
	}

	switch (choice) {
	case 1:
	    AddressBookManager operator = new AddressBookManager();
	    operate(operator);
	    break;
	case 2:
	    AddressBookHandler handler = new AddressBookHandler();
	    operate(handler);
	    break;
	default:
	    break;
	}

    }

    /**
     * @param operator
     * 
     */
    private static void operate(Object operator) {
	FileSystem fileSystem = null;
	fileSystem = FileSystem.getFileSystem();
	String fileName = null;

	if (operator instanceof AddressBookManager) {
	    operator = (AddressBookManager) operator;
	    while (true) {
		int choice = Utility.getOperationChoice(MANAGER_METHODS);
		switch (choice) {
		case 1:
		    System.out.println("Enter the Address Book  name");
		    fileName = Utility.getNewFileName();
		    addressBook = ((AddressBookManager) operator).createAddressBook(fileName);
		    break;
		case 2:

		    Utility.printMessages("Enter the name of address book to be fetched");
		    fileName = Utility.getStringvalue();
		    File deleteFile = new File(FILE_PATH + fileName + EXT);
		    if (!deleteFile.exists()) {
			Utility.printMessages("Address Book not present");
			break;
		    }

		    deleteFile.delete();
		    Utility.printMessages("Address Book deleted");
		    break;
		case 3:
		    fileSystem = FileSystem.getFileSystem();
		    if (addressBook != null) {
			Utility.printMessages("Do you want to save " + addressBook.getTitle(addressBook.getFile())
				+ "  " + "[true|false] ?");
			boolean response = Utility.getBooleanValue();
			if (response) {
			    fileSystem.write(addressBook, addressBook.getFile());
			}
			break;
		    }
		    Utility.printMessages("create a Address Book first ");
		    break;
		case 4:
		    java.io.FileFilter filter = (File name) -> {
			if (name.getName().toLowerCase().endsWith(EXT)) {
			    return true;
			}
			return false;
		    };
		    File directory = new File(FILE_PATH);
		    File[] allAddressBooks = directory.listFiles(filter);
		    Utility.printMessages("Address books  are......");
		    for (File selectedFiles : allAddressBooks) {
			Utility.printMessages(Arrays.toString(selectedFiles.getName().split(".json")));
			
			
		    }
		    Utility.printMessages("......");
		    break;
		case 5:

		    Utility.printMessages("Enter old Address Book name");

		    String oldName = Utility.getStringvalue();
		    Utility.printMessages("Enter the Address Book new name");
		    String newName = Utility.getStringvalue();
		    ((AddressBookManager) operator).renameAddressBook(oldName, newName);
		    Utility.printMessages("Successfully renamed the Address Book");
		    break;
		case 6:
		    Utility.printMessages("Get Address Book");
		    Utility.printMessages("Enter the Address Book Name");
		    String addressBookName = Utility.getStringvalue();
		    addressBook = ((AddressBookManager) operator).getAddressBook(addressBookName);
		    Utility.printMessages("Address Book Fetch success");
		    dashBoard(2);
		    break;

		default:
		    dashBoard();
		    break;
		}
	    }

	} else {

	    AddressBookHandler handler = (AddressBookHandler) operator;
	    if (addressBook == null) {
		Utility.printMessages("Address Book is not selected");
		Utility.printMessages("returning....");

		dashBoard();
		return;
	    }
	    Utility.printMessages("Your current Address Book is " + Arrays.toString( addressBook.getFile().getName().split(".json")));
	    while (true) {

		int choice = Utility.getOperationChoice(HANDLER_METHODS);
		switch (choice) {
		case 1:
		    handler.addPersonWrapper(addressBook);

		    break;
		case 2:
		    handler.updatePersonWrapper(addressBook);
		    break;
		case 3:
		    handler.deletePersonWrapper(addressBook);
		    break;
		case 4:
		    int count = handler.countPersonsInAddressBookWrapper(addressBook);
		    System.out.println("Number of persons in the Address Book are : " + count);

		    break;

		case 5:
		    String fullName = handler.getFullNameWrapper(addressBook);

		    Utility.printMessages(" Full name of the person is : " + fullName);

		    break;

		case 6:

		    Person p = handler.getPersonWrapper(addressBook);

		    Utility.printMessages(p.toString());

		    break;

		default:
		    dashBoard();
		    break;
		}

	    }

	}

    }

}
