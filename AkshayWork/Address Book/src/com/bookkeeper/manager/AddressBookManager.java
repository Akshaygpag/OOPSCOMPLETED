package com.bookkeeper.manager;

import java.io.File;
import java.util.Arrays;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.bookkeeper.entity.AddressBook;
import com.bookkeeper.main.AddressBookHandler;
import com.bookkeeper.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class AddressBookManager {
    private static final String FILE_PATH = "/home/bridgeit/addressbookkeeper/";
    private static final String EXT = ".json";
    private static final Logger LOGGER = Logger.getLogger(AddressBookManager.class);

    public AddressBookManager() {
	BasicConfigurator.configure();
    }

    public AddressBook createAddressBook(String name) {

	AddressBook addressBook = new AddressBook();
	addressBook.setFile(new File(FILE_PATH + name + EXT));

	return addressBook;

    }

    public void deleteAddressBook(String name) {
	File deleteFile = new File(FILE_PATH + name + EXT);
	if (!deleteFile.exists()) {

	    System.out.println("Entered invalid name");
	    return;

	}

	deleteFile.delete();
	System.out.println("address book deleted success");

    }

    public AddressBook getAddressBook(String name) {
	AddressBook addressBook = null;
	try {
	    File getAddressBook = new File(FILE_PATH + name + EXT);
	    if (!getAddressBook.exists()) {

		System.out.println("Entered invalid name");
		return addressBook;

	    }

	    addressBook = Utility.getAddressBook(getAddressBook);
	    if (addressBook == null) {

		addressBook = new AddressBook();
		addressBook.setFile(getAddressBook);

	    }
	    return addressBook;

	} catch (Exception e) {

	    System.out.println("E" + e.getMessage());
	    return null;
	}

    }

    public void renameAddressBook(String nameOld, String newName) {

	AddressBook addressBook = null;
	try {
	    File getAddressBook = new File(FILE_PATH + nameOld + EXT);
	    if (!getAddressBook.exists()) {

		System.out.println("Entered invalid name");
		return;
	    }

	    getAddressBook.renameTo(new File(FILE_PATH + newName + EXT));
	    return;
	} catch (Exception e) {

	    System.out.println("E" + e.getMessage());
	}

    }

    public void listAllAddressBooks() {

	File directory = new File(FILE_PATH);

	if (directory.isDirectory()) {

	    System.out.println("Yes the folder is there ");

	    java.io.FileFilter filter = (File name) -> {

		if (name.getName().toLowerCase().endsWith(EXT)) {

		    return true;

		}
		return false;

	    };

	    File[] allAddressBooks = directory.listFiles(filter);

	    System.out.println("Address books  are......");
	    for (File selectedFiles : allAddressBooks) {

		System.out.println(Arrays.toString( selectedFiles.getName().split(".json")));

	    }

	}

    }

}
