package com.bookkeeper.interfaces;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 04-Jun-2018
 */

public interface AddressBookManager {
    File getFile();

    String getTitle(File fileName);

    void setFile(File fileName);

    default void deleteFile(File file) {
	try {

	    if (file.exists()) {
		file.delete();

	    } else {

		throw new Exception("File not found");

	    }

	} catch (Exception e) {

	    System.out.println(e.getMessage());

	}

    }

}
