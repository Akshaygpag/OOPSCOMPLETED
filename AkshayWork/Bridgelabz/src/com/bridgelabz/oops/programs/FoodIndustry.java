package com.bridgelabz.oops.programs;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.bridgelabz.oops.classes.Comodity;
import com.bridgelabz.oops.classes.GodownInventory;
import com.bridgelabz.oops.classes.InventoryFactory;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 30-May-2018
 */
public class FoodIndustry {
    static String path = "/home/bridgeit/fileHolder/GodownInventory.json";

    /**
     * @param args
     * @throws ParseException
     * @throws org.json.simple.parser.ParseException
     * @throws IOException
     * @throws org.json.simple.parser.ParseException
     * 
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws ParseException, IOException, org.json.simple.parser.ParseException {
	List<Comodity> goodsList = null;
	InventoryFactory factory = InventoryFactory.getFactory();
	List<JSONObject> jsonList = factory.getObjects(path);
	List<GodownInventory> allInventory = new ArrayList<GodownInventory>();
	for (JSONObject jsonObject : jsonList) {
	    GodownInventory inventory = new GodownInventory();// GOODS INVENTORTY CREATED
	    Iterator<JSONObject> it = jsonObject.keySet().iterator();
	    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");// SIMPLE
	    int start = -1;
	    int reset = 0;
	    while (it.hasNext()) {
		Object x = it.next();
		if (jsonObject.get(x) instanceof JSONArray) {
		    start++;
		    inventory.setName(x.toString());
		    goodsList = new ArrayList<Comodity>();// CREATED LIST OF
		    List<JSONObject> typeList = (List<JSONObject>) jsonObject.get(x);
		    for (JSONObject eachGoodsList : typeList) {
			Comodity comodity = new Comodity();
			comodity.setType(eachGoodsList.get("type").toString());
			comodity.setQuantity(Long.parseLong(eachGoodsList.get("quantity").toString()));
			comodity.setPrice(Double.parseDouble(eachGoodsList.get("price").toString()));
			goodsList.add(start, comodity);
		    }
		    inventory.setTypes(goodsList);

		} else {
		    inventory.setNextSupply(formatDate.parse(jsonObject.get(x).toString()));//
		}
		reset++;

		if (reset % 2 == 0) {
		    allInventory.add(inventory);
		    reset = 0;
		}
	    }
	}
	JSONArray array = new JSONArray();
	for (GodownInventory inventory : allInventory) {
	    JSONObject inventoryObject = new JSONObject();
	    inventoryObject.put("name", inventory.getName());
	    float total = 0.0F;
	    long quantity = 0L;
	    for (Comodity object : inventory.getTypes()) {
		total += object.getPrice() * object.getQuantity();
		quantity += object.getQuantity();
	    }
	    inventoryObject.put("total", String.format("%.2f", total));
	    inventoryObject.put("Quantity", quantity);
	    array.add(inventoryObject);
	}
	System.out.println(array.toJSONString());

    }

}
