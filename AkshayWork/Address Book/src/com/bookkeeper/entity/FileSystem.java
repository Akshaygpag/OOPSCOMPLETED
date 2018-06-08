package com.bookkeeper.entity;

import java.io.File;

import org.apache.log4j.Logger;

import com.bookkeeper.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public class FileSystem {

    private static final String FILE_NULL = "File Object is null";
    private static final FileSystem fileSystem = new FileSystem();

    private static final Logger LOGGER = Logger.getLogger(FileSystem.class);

    public AddressBook readFile(File file) {
	AddressBook addressBook = null;
	try {

	    if (file == null) {

		throw new Exception(FILE_NULL);

	    }

	    addressBook = Utility.getAddressBook(file);

	} catch (Exception e) {
	    LOGGER.error("Exception in [FileSystem][readFile] " + e.getMessage());
	}
	return addressBook;
    }

    public void write(AddressBook addressBook, File file) {

	try {

	    if (file == null) {

		throw new Exception(FILE_NULL);

	    }
	    Utility.writeAddressBookToFile(addressBook, file);
	} catch (Exception e) {

	}

    }

    public static FileSystem getFileSystem() {

	return fileSystem;

    }

}
