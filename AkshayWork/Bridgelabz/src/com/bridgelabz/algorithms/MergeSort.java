package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * SORT INTS USING MERGE SORT
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class MergeSort {

    public static void main(String[] args) {
	Integer a[] = { 0, 2, 3, 1, 9, 90, 0, 0, 812 };

	System.out.println("printing the value befor sorting");
	for (int i = 0; i < a.length; i++) {
	    System.out.println(a[i]);
	}

	AlgorithmUtil.mergeSort(a);
	System.out.println("printing the value after sorting ");
	for (int i = 0; i < a.length; i++) {
	    System.out.println(a[i]);
	}
    }

}