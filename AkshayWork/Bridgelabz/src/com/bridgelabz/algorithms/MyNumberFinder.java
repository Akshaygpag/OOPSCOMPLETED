package com.bridgelabz.algorithms;

import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * GUESS THE NUMBER BY USING TIME COMPLEXITY OF LOG n BASE 2
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class MyNumberFinder {
    static int N;

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE THE INPUTS FROM THE USER AND THEN ASK FOR THE USER TO
	// INPUT THE TRUE/FALSE FOR THE NUMBER RANGE

	N = Integer.parseInt(args[0]);
	System.out.println("Think a number between 0 to " + (N - 1));
	numberFinder(createArray(N));

    }

    private static int[] createArray(int n2) {
	// THIS METHOD WILL CREATE ARRAY WITH VALUES SAME AS INDEX

	int[] arrayData = new int[n2];
	for (int i = 0; i < n2; i++) {

	    arrayData[i] = i;

	}
	return arrayData;
    }

    private static void numberFinder(int[] array) {
	// THIS METHOD WILL RETURN THE NUMBER THAT THE USER HAD IN MIND
	int low = 0;
	int high = array.length - 1;
	int mid = (low + high) / 2;

	int times = (int)(Math.log(N) / Math.log(2));
	System.out.println("times to be asked question : " + times);
	while (low <= high ) {
	    if (low == high) {
		System.out.println("The number choosen is " + mid);
		break;
	    } else {
		if (getUserResponse(mid, times-- 

		)) {
		    high = mid;
		    mid = (low + high) / 2;

		} else {
		    low = mid + 1;
		    mid = (low + high) / 2;

		}

	    }
	}


    }

    private static boolean getUserResponse(int mid, int times) {
	// THIS METHOD WILL TAKE IN THE USER RESPONSE AS OF FALSE OR TRUE DEPENDING UON
	// THE INTEGRITY OF THE QUESTION
	System.out.println("Is number lower than  or equal to " + mid + " ?");
	System.out.println("Times left " + times);
	return Utility.getBooleanValue();
    }

}
