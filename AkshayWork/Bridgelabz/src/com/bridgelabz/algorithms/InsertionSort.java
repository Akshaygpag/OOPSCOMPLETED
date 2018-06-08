package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * SORT STRINGS USING INSERTION SORT
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class InsertionSort {

    public static void main(String[] args) {
	// THIS METHOD USED LIST AS INPUTS AND CALLS THE INSERTION SORT FROM THE
	// ALGOUTILITY CLASS FOR THE STRING
	/*
	 * List<String> listWords = new ArrayList<String>(); listWords.add("apple");
	 * listWords.add("ball"); listWords.add("dog"); listWords.add("cat");
	 * listWords.add("elephant"); listWords.add("fan"); listWords.add("goat");
	 * listWords.add("helicopter"); listWords.add("india"); listWords.add("joker");
	 */
	List<Integer> listWords = new ArrayList<Integer>();
	listWords.add(10);
	listWords.add(1120);
	listWords.add(11230);
	listWords.add(1432340);
	listWords.add(1234230);
	listWords.add(12342340);
	listWords.add(1234340);
	listWords.add(110);
	listWords.add(150);
	listWords.add(110);
	listWords.add(3210);
	listWords.add(1110);

	Integer[] unsortedData = new Integer[listWords.size()];

	unsortedData = listWords.toArray(unsortedData);

	System.out.println("------------------------------");
	Integer[] sortedData = AlgorithmUtil.insertionSort(unsortedData);

	for (Integer s : sortedData) {
	    System.out.println(s);
	}

    }

}
