package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * SORT INTS USING BUBBLE SORT
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class BubbleSortIntegers {

    public static void main(String[] args) {
	// TAKES A LIST AS INPUT AND PASSES THE LIST REF TO THE METHOD TO SORT THE DATA
	// IN NATURAL SORTING USING BUBBLE SORT

	Integer[] unSortedData = null;

	List<Integer> unSortedDataList = new ArrayList<Integer>();
	Integer userInput = 0;
	System.out.println("Enter intergers values and enter -777 to stop the input taking");
	while (((userInput = Utility.getIntergerValue()) != -777)) {

	    unSortedDataList.add(userInput);

	    System.out.println("Enter intergers values and enter -777 to stop the input taking");
	}

	unSortedData = new Integer[unSortedDataList.size()];
	int index = 0;
	for (Integer i : unSortedDataList) {
	    unSortedData[index++] = i.intValue();
	}

	Integer[] sortedData = AlgorithmUtil.bubbleSortArrays(unSortedData);

	System.out.println("----------");
	for (Integer i : sortedData) {

	    System.out.println(i);

	}

    }

}
