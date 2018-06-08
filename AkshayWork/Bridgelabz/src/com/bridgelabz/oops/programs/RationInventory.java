package com.bridgelabz.oops.programs;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.oops.classes.InventoryClass;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */
public class RationInventory {

    /**
     * @param args
     * @throws ParseException
     * @throws IOException
     * 
     */
    public static void main(String[] args) throws IOException, ParseException {
	String filePath = "/home/bridgeit/fileHolder/Inventory.json";
	File file = new File(filePath);

	FileReader reader = new FileReader(file);
	// READS THE FILE CONTENTS

	JSONParser parser = new JSONParser();
	//
	List<JSONObject> fileContents = (List<JSONObject>) parser.parse(reader);

	List<InventoryClass> allInventory = fileContents.stream().map(jsonObject -> {
	    InventoryClass inventory = null;
	    inventory = new InventoryClass();
	    inventory.setName(jsonObject.get("name").toString());
	    inventory.setWeight(Double.parseDouble(jsonObject.get("weight").toString()));
	    inventory.setPrice(Double.parseDouble(jsonObject.get("price").toString()));
	    return inventory;
	}).collect(Collectors.toList());

	for (InventoryClass inventoryClass : allInventory) {
	    System.out.print("The inventory item name is : " + inventoryClass.getName());
	    System.out.print(
		    "\tThe inventory item valuation is : " + (inventoryClass.getPrice() * inventoryClass.getWeight()));
	    System.out.println();
	}
    }
}
