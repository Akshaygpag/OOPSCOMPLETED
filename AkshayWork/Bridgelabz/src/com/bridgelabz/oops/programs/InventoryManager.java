/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.oops.programs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.bridgelabz.oops.classes.Inventory;
import com.bridgelabz.oops.classes.InventoryFactory;

public class InventoryManager {

    static String path = "/home/bridgeit/fileHolder/Inventory.json";
    /**
     * @param args
     * @throws ParseException
     * @throws IOException
     * 
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException, ParseException {
	InventoryFactory factory = InventoryFactory.getFactory();
	List<JSONObject> jsonList = factory.getObjects(path);
	List<Inventory> allInventory = new ArrayList<Inventory>();
	for (JSONObject jsonObject : jsonList) {
	    Inventory inventory = new Inventory();
	    inventory.setProduct(jsonObject.get("name").toString());
	    inventory.setInventoryPrice(Double.parseDouble(jsonObject.get("weight").toString())
		    * Double.parseDouble(jsonObject.get("price").toString()));
	    allInventory.add(inventory);
	}

	JSONArray array = new JSONArray();
	for (Inventory inventory : allInventory) {
	    JSONObject inventoryObject = new JSONObject();
	    inventoryObject.put("price", inventory.getInventoryPrice());
	    inventoryObject.put("name", inventory.getProduct());
	    array.add(inventoryObject);
	}
	System.out.println(array.toJSONString());
    }
}
