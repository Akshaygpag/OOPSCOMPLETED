package com.bridgelabz.datastructures.programs;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.functionalprogramming.util.Utility;

public class OrderedListMain {
    private static final String FILE_PATH = "/home/bridgeit/fileHolder/OrderList.txt";// GET FILE PATH

    public static void main(String[] args) {
	// code used for testing
	OrderedList<Integer> list = new OrderedListImpl<Integer>();

	File file = new File(FILE_PATH);
	FileReader read = null;
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
			Node<Integer> n = new Node<Integer>();
			n.setInfo(Integer.parseInt(insertData));
			// n.setInfo(insertData.trim());
			list.add(n);

		    }

		}
		System.out.println("Enter the number to be searched");

		Node<Integer> n = Utility.getNodeValue();
		System.out.println("File size before deleting is  " + list.size());
		if (list.search(n)) {

		    System.out.println("key found ");
		    System.out.println("deleting.....");

		    list.remove(n);

		    System.out.println("deletion completed .");
		    System.out.println("File items  after  deleting is  " + list.size());

		} else {

		    list.add(n);
		    System.out.println("Element is added.");
		}

		file.delete();
		file.createNewFile();

		fw = new FileWriter(file);
		StringBuffer listContents = new StringBuffer();
		System.out.println("--------------------");

		boolean firstValue = true;
		while (!list.isEmpty()) {
		    String dataListSingle = list.pop(0).getInfo().toString();
		    if (firstValue) {
			listContents.append(dataListSingle);
			firstValue = false;
		    } else {
			listContents.append("," + dataListSingle);
		    }
		}
		fw.write(listContents.toString().substring(0, listContents.toString().length()));
		fw.flush();
		System.out.println("Writing to file completed");

	    }

	    catch (Exception e) {
		System.out.println("cannot do the file read and write operations " + e.getMessage());

		e.printStackTrace();
	    }
	} catch (Exception e) {

	    System.out.println("cannot do the file read and write operations " + e.getMessage());
	    e.printStackTrace();
	}

	finally {

	    try {
		fw.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

    }

}
