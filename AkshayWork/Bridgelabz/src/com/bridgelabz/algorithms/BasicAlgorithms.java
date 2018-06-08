package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * INSERTION SORT ,BUBBLE SORT AND BINARY SEARCH FOR BOTH INTS AND STRINGS
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class BasicAlgorithms {

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE IN THE USER INPUT FOR THE CHOICE OF OPERATIONS TO BE
	// PERFORMED

	while (true) {
	    System.out.println("------------------------------------");
	    System.out.println("Enter choice for the operations ");
	    System.out.println("1. binarySearch for int");
	    System.out.println("2. binarySearch for String");
	    System.out.println("3. insertion sort for int");
	    System.out.println("4. insertion sort for String");
	    System.out.println("5. bubble sort for int");
	    System.out.println("6. bubble sort for Stirng");
	    System.out.println("7.Exit");
	    int request = Utility.getIntergerValue();
	    // int[] sortedIntData = null;
	    String[] sortedStringData = null;
	    int mid = -1;
	    long start, end;
	    switch (request) {

	    case 1:
		System.out.println("Enter the data ");
		int data = Utility.getIntergerValue();
		char[] dataUsed = String.valueOf(data).toCharArray();
		System.out.println("Enter the key value to be searched in the data list");
		int intKey = Utility.getIntergerValue();
		String key = String.valueOf(intKey);
		Character[] intHolder = new Character[dataUsed.length];
		for (int i = 0; i < dataUsed.length; i++) {
		    intHolder[i] = dataUsed[i];
		}

		start = System.nanoTime();
		mid = AlgorithmUtil.binarySearch(intHolder, key.charAt(0));
		end = System.nanoTime();
		System.out.println("Time taken in nano seconds " + (end - start));
		if (mid != -1) {
		    System.out.println("Element found at position " + mid);

		}
		break;

	    case 2:
		System.out.println("Enter the string :");
		String stringData = Utility.getUserStringValue();
		System.out.println("Enter the key value to be searched in the data list");
		String stringKey = null;
		stringKey = Utility.getUserStringValue();
		start = System.nanoTime();
		mid = AlgorithmUtil.binarySearch(AlgorithmUtil.stringToStringArray(stringData), stringKey);
		end = System.nanoTime();
		System.out.println("Time taken in nano seconds " + (end - start));
		if (mid != -1) {
		    System.out.println("Element found at position " + mid);

		}
		break;

	    case 3:
		System.out.println("Enter the unsorted  int  to sort using insertion sort");
		int unSortedIntData = Utility.getIntergerValue();
		;
	Integer[] insertionInt=	Utility.convertIntToIntArray(unSortedIntData);
		start = System.nanoTime();
		Integer[] insertionSortIntData = AlgorithmUtil
			.insertionSort(insertionInt);
		end = System.nanoTime();
		System.out.println("Time taken in nano seconds " + (end - start));
		Utility.printArray(insertionSortIntData);
		break;

	    case 4:

		System.out.println("Enter the unsorted string array to sort using insertion sort");
		String insertSortStringUnSorted = Utility.getUserStringValue();
		String[] userStringAsArray = AlgorithmUtil.stringToStringArray(insertSortStringUnSorted);
		start = System.nanoTime();
		sortedStringData = AlgorithmUtil.insertionSort(userStringAsArray);
		end = System.nanoTime();
		System.out.println("Time taken in nano seconds " + (end - start));
		Utility.printStringArray(sortedStringData);
		break;

	    case 5:
		System.out.println("Sorting the ints using bubble sort");
		Integer userIntBubbleData = Utility.getIntergerValue();
		start = System.nanoTime();
		Integer[] bubbleSortedInts = AlgorithmUtil
			.bubbleSortArrays(Utility.convertIntToIntArray(userIntBubbleData));
		end = System.nanoTime();
		System.out.println("Time taken in nano seconds " + (end - start));
		Utility.printArray(bubbleSortedInts);

		break;

	    case 6:
		System.out.println("Sorting the Stirngs using bubble sort ");
		String[] stringDataUnsortedBubble = Utility.getArrayDataString();

		start = System.nanoTime();
		String[] sortedData = AlgorithmUtil.bubbleSortArrays(stringDataUnsortedBubble);
		end = System.nanoTime();
		System.out.println("Time taken in nano seconds " + (end - start));
		Utility.printStringArray(sortedData);

		break;
	    default:
		System.out.println("Exiting froim the menu....");
		System.exit(1);

	    }

	}

    }

}
