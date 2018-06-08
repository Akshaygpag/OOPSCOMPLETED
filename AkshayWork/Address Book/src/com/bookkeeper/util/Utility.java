package com.bookkeeper.util;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.bookkeeper.entity.Address;
import com.bookkeeper.entity.AddressBook;
import com.bookkeeper.entity.Person;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class Utility {
    private static final Logger LOGGER = Logger.getLogger(Utility.class);
    private static final String FILE_PATH = "/home/bridgeit/addressbookkeeper/";
    private static final String EXT = ".json";
    private static final Scanner scanner = new Scanner(System.in);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static int getOperationChoice(String message) {
	System.out.println(message);
	int data = scanner.nextInt();

	scanner.nextLine();
	return data;
    }

    public static void printMessages(String message) {
	System.out.println(String.format("%-10s", message));

    }

    /**
     * @param file
     * @return
     * 
     */
    public static AddressBook getAddressBook(File file) {

	AddressBook addressBook = null;
	try {
	    addressBook = Utility.getAddressBookFromFile(file);

	} catch (Exception e) {

	    LOGGER.error("Exception at [Utility][getAddressBook] " + e.getMessage());

	}
	return addressBook;
    }

    /**
     * @param file
     * @return
     * 
     */
    private static AddressBook getAddressBookFromFile(File file) {
	String fileContents = null;

	AddressBook addressBook = null;
	try {

	    fileContents = Utility.getJSONFileData(file);
	    if (fileContents.trim().length() == 0 || fileContents == null) {

		return null;

	    }

	    addressBook = Utility.getAddressBookFromString(fileContents);
	} catch (Exception e) {
	    LOGGER.error("Exception at [Utility][getAddressBookFromFile] " + e.getMessage());

	}

	return addressBook;
    }

    /**
     * @param fileContents
     * @return
     * 
     */
    private static AddressBook getAddressBookFromString(String fileContents) {
	AddressBook addressBook = null;
	try {

	    addressBook = mapper.readValue(fileContents.getBytes(), AddressBook.class);

	} catch (Exception e) {
	    LOGGER.error("Exception at [Utility][getAddressBookFromString] " + e.getMessage());

	}
	return addressBook;

    }

    /**
     * @param file
     * 
     */
    @SuppressWarnings("resource")
    private static String getJSONFileData(File file) {
	LOGGER.info("Entered [Utility][getJSONFileObjectList] ");
	StringBuffer fileContents = null;
	FileReader reader = null;
	int singleChar = 0;
	try {

	    if (!file.exists()) {

		file.createNewFile();

	    }
	    reader = new FileReader(file);
	    fileContents = new StringBuffer();
	    while ((singleChar = reader.read()) != -1) {
		fileContents.append((char) singleChar);
	    }

	    LOGGER.info("|" + fileContents.toString() + "|");
	    return fileContents.toString();
	} catch (Exception e) {

	    LOGGER.error("Exception at [Utility][getJSONFileObjectList] " + e.getMessage());
	    return null;
	}

    }

    /**
     * @param addressBook
     * @param file
     * 
     */
    public static void writeAddressBookToFile(AddressBook addressBook, File file) {

	try {

	    if (!file.exists()) {

		file.createNewFile();
	    }
	    addressBook.setChangesSinceLastSave(false);
	    mapper.writeValue(file, addressBook);

	} catch (Exception e) {

	    LOGGER.error("Exception at [Utility][writeAddressBookToFile] " + e.getMessage());

	}

    }

    public static int getInegerValue(String message) {
	Utility.printMessages(message);
	int data = scanner.nextInt();
	scanner.nextLine();
	return data;

    }

    /**
     * @return
     * 
     */
    public static String getStringvalue() {
	return scanner.nextLine();
    }

    public static Person getPerson() {

	String firstName, lastName, phone, address, city, state, zipCode;
	Utility.printMessages("enter first name");
	firstName = Utility.getStringvalue();
	Utility.printMessages("enter last name");
	lastName = Utility.getStringvalue();
	Utility.printMessages("enter phone number");
	phone = Utility.getStringvalue();
	Utility.printMessages("enter Address city");
	city = Utility.getStringvalue();
	Utility.printMessages("enter Address state");
	state = Utility.getStringvalue();
	Utility.printMessages("enter Address zip code");
	zipCode = Utility.getStringvalue();
	Utility.printMessages("enter Address ");
	address = Utility.getStringvalue();

	Address personAddress = new Address(address, city, state, zipCode);
	Person person = new Person(firstName, lastName, personAddress, phone);

	return person;

    }

    /**
     * @return
     * 
     */
    public static boolean getBooleanValue() {
	return scanner.nextBoolean();
    }

    public static String getNewFileName() {

	String fileName = Utility.getStringvalue();
	File file = new File(FILE_PATH + fileName + EXT);
	if (file.exists()) {
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
		    System.out.println(selectedFiles.getName());
		}
		System.out.println("Select any other name ..");
		fileName = Utility.getStringvalue();

	    }
	}
	return fileName;

    }
}
