package com.application.addressbook.io;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 05-Jun-2018
 */

public class AddressBookIO {
    static final ObjectMapper mapper = new ObjectMapper();
    public static ObjectMapper getObjectmapper() {
	return mapper;
    }
}
