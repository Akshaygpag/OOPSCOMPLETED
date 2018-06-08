package com.application.clinic.io;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.application.clinic.entities.Clinic;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 06-Jun-2018
 */

public class Writer extends Mapper {

    public static void writeFile(File file, Clinic objectToFile) {
	try {

	    mapper.writeValue(file, objectToFile);

	} catch (EOFException e) {
	    return;

	}

	catch (Exception e) {
	    // TODO: handle exception
	}
	return;
    }
}
