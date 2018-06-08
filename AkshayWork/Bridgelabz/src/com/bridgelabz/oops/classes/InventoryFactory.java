
package com.bridgelabz.oops.classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */
public class InventoryFactory {
    public static final InventoryFactory factory = new InventoryFactory();

    private InventoryFactory() {}

    /**
     * @return
     * 
     */
    public static InventoryFactory getFactory() {
	return factory;
    }

    /**
     * @param path
     * @return
     * @throws ParseException
     * @throws IOException
     * 
     */
    @SuppressWarnings("unchecked")
    public List<JSONObject> getObjects(String path) throws IOException, ParseException {
	File file = new File(path);
	FileReader reader = new FileReader(file);
	JSONParser parser = new JSONParser();
	return (List<JSONObject>) parser.parse(reader);
    }
}
