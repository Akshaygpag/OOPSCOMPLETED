package com.demo;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 07-Jun-2018
 */

public class Src {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	ObjectMapper mapper = new ObjectMapper();

	try {
	    // A ref = mapper.readValue(, A.class);
	    JsonNode x = mapper.readTree(new File("/home/bridgeit/Sample@/" + "temp.json"));

	    A ref1 = mapper.readValue(x, A.class);

	    System.out.println(ref1);

	} catch (EOFException e) {

	    System.out.println("Failed");
	    return;
	}

	catch (Exception e) {
	    // TODO: handle exception
	    return;

	}

    }

}

class A {

    String name = "King Maker";

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return name;

    }

}
