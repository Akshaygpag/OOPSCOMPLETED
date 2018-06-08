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

public class Reader extends Mapper {

    public static Clinic readFile(File file) {

	try {

	    try {
		return mapper.readValue(file, Clinic.class);
	    } catch (EOFException e) {
		// TODO Auto-generated catch block
		throw e;
	    } catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		throw e;
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		throw e;
	    }

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    return null;

	}
    }

}
