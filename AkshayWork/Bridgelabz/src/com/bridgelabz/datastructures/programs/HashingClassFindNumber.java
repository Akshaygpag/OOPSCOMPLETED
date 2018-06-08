package com.bridgelabz.datastructures.programs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * THIS CLASS IS USED TO CREATE HASHAND STORES THE VALUES AND PERFORMES THE
 * OPERATIONS ON THE LIST OF NUMBERS STORED
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 24-May-2018
 */
public class HashingClassFindNumber {
    private static final String FILE_PATH = "/home/bridgeit/fileHolder/HashingList.txt";// GET FILE PATH

    /**
     * MAIN METHOD WILL CAUSE THE FETCHING THE FILE DATA AND THEN STORING THEM IN
     * THE RESPECTIVE AREA
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
	// THIS METHOD WILL READ NUMBERS FROM FILES AND TAKE USER VALUE
	@SuppressWarnings("unchecked")
	// OrderedList<Integer>[] chain = new OrderedListImpl[11];// CREATE A ARRAY OF
	// ORDERED LIST WITH CASTED TO
	Map<Integer, OrderedList<Integer>> map = new HashMap<Integer, OrderedList<Integer>>(); // INTERFACE

	File file = new File(FILE_PATH);// FETCH AND CREATE A OBJECT FOR THE FILE
	FileReader read = null;// FILEREADER
	if (!file.exists()) {
	    System.out.println("File resource could not be found Error :404");
	    return;
	}
	FileWriter fw = null;
	try {
	    read = new FileReader(file);
	    int c = -1;
	    StringBuffer sb = new StringBuffer();
	    try {
		while ((c = read.read()) != -1) {
		    sb.append((char) c);
		}
		System.out.println("File contents starts.......");
		System.out.println(sb.toString());
		System.out.println("File contents ends......");
		if (file.length() != 0) {
		    String[] data = sb.toString().split(",");
		    for (String insertData : data) {
			if (insertData.trim().length() > 0) {
			    Node<Integer> n = new Node<Integer>();
			    // System.out.println(insertData.trim());
			    n.setInfo(Integer.parseInt(insertData.trim()));
			    Integer remainder = n.getInfo() % 11;

			    OrderedList<Integer> listFetching = map.get(remainder);

			    if (listFetching == null) {
				map.put(remainder, new OrderedListImpl<Integer>());
			    }
			    map.get(remainder).add(n);
			}
		    }
		}

		Set<Integer> items = map.keySet();
		TreeSet<Integer> treeSet = new TreeSet<Integer>(items);

		Iterator<Integer> iterableItems = treeSet.iterator();

		while (iterableItems.hasNext()) {
		    Integer integerValue = iterableItems.next();
		    OrderedList<Integer> listOrder = map.get(integerValue);
		    System.out.print("Bucket " + integerValue + " : ");

		    List<Integer> listDisplayer = new ArrayList<Integer>();
		    for (int i = 0; i < listOrder.size(); i++) {

			listDisplayer.add(listOrder.get(i).getInfo());

		    }
		    Integer[] dataHolder = new Integer[listDisplayer.size()];
		    dataHolder = listDisplayer.toArray(dataHolder);
		    System.out.println(Arrays.toString(dataHolder));
		    System.out.println();
		}

		System.out.println("Enter the number to be searched");
		Node<Integer> n = Utility.getNodeValue();
		Integer remainder = n.getInfo() % 11;
		OrderedList<Integer> enteredData = map.get(remainder);
		if (enteredData == null) {

		    map.put(remainder, new OrderedListImpl<Integer>());
		}

		if (map.get(remainder).search(n)) {
		    System.out.println("key found ");
		    System.out.println("deleting.....");
		    map.get(remainder).remove(n);
		    System.out.println("deletion completed .");
		} else {
		    map.get(remainder).add(n);
		    System.out.println("Element is added.");
		}
		file.delete();
		file.createNewFile();
		fw = new FileWriter(file);
		StringBuffer listContents = new StringBuffer();
		System.out.println("--------------------");

		for (Integer i : map.keySet()) {

		    while (!map.get(i).isEmpty() && map.get(i) != null) {
//			System.out.println("inside the loop");
			String dataListSingle = map.get(i).pop().getInfo().toString();

			listContents.append("," + dataListSingle);

		    }
		}

		if (listContents.toString().trim().length() == 0) {
		    fw.write("");
		} else {
		    fw.write(listContents.toString().substring(1, listContents.toString().length()));
		}
		fw.flush();
		System.out.println("Writing to file completed");
	    } catch (Exception e) {
		System.out.println("cannot do the file read and write operations " + e.getMessage());
		e.printStackTrace();
	    }
	} catch (Exception e) {
	    System.out.println("cannot do the file read and write operations " + e.getMessage());
	    e.printStackTrace();
	} finally {

	    try {
		fw.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }

	}

    }
}
