package com.bridgelabz.datastructures.programs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.bridgelabz.algorithm.impl.UnOrderedList;
import com.bridgelabz.algorithm.interfaces.List;
import com.bridgelabz.functionalprogramming.util.Utility;

public class UnOrderedLinkedList {
    private static final String FILE_PATH = "/home/bridgeit/fileHolder/wordList.txt";// GET FILE PATH

    public static void main(String[] args) {

	List<String> list = new UnOrderedList<String>();
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
		String[] data = sb.toString().split(",");
		for (String insertData : data) {
		    Node<String> n = new Node<String>();
		    if (insertData.trim().length() > 0) {
			n.setInfo(insertData.trim());
			list.add(n);
		    }
		}
		System.out.println("Enter the word to be searched");
		String keyData = Utility.getUserStringValue();
		Node<String> n = new Node<String>();
		n.setInfo(keyData);
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
		    System.out.println("File items  after  adding is  " + list.size());

		    list.size();
		}
		file.delete();
		file.createNewFile();
		fw = new FileWriter(file);
		StringBuffer listContents = new StringBuffer();
		System.out.println("--------------------");
		boolean firstValue = true;
		while (!list.isEmpty()) {
		    String dataListSingle = list.pop(0).getInfo();
		    if (firstValue) {
			listContents.append(dataListSingle);
			firstValue = false;
			System.out.println("leaves");
		    } else {
			listContents.append("," + dataListSingle);
		    }
		}
		fw.write(listContents.toString().substring(0, listContents.toString().length()));
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
