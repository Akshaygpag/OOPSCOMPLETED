package com.bridgelabz.algorithms;

import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * THIS WILL TAKE THE MONETORY VALUE AND RETURN THE DENOMINATIONS SPECIFIED
 * 
 * @author Akshay
 * @since 21-05-2018
 * @version 1.0.1
 *
 */
public class VendingmachineOptimal {
    static long[] changeHolders;

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE THE USER INPUT FOR THE CHANGE THAT IS TO BE GENERATED
	Integer[] denominations = { 1000, 500, 1, 2, 5, 20,10, 50, 100 };
	changeHolders = new long[denominations.length];
	System.out.println("Enter the change that is to be produced");

	long changeRequired = Utility.getLongValue();
	denominations = Utility.sortDescendingOrder(denominations);

	int i = 0;
	try {

	    changeProducer(denominations, i, changeRequired);//CALL THE CHANGEPRODUCER WHICH IS RECURSSIVE

	} catch (Exception e) {

	    e.printStackTrace();

	}
	for (int j = 0; j < denominations.length; j++) {
	    if (changeHolders[j] != 0) {

		System.out.println(String.format("%-4d X %d", denominations[j], changeHolders[j]));
	    }

	}

    }

    private static void changeProducer(Integer[] denominations, int incrementor, long change) {
	// THIS METHOD WILL BE CALLED RECURSSIVELY AND STORE VALUES IN RESPECTIVE ARRAY
	// INDEX
	try {

	    if (change > 0 && incrementor < denominations.length) {
		int notesCounter = 0;
		while (change >= denominations[incrementor]) {
		    change -= denominations[incrementor];
		    notesCounter++;
		}
		changeHolders[incrementor] = notesCounter;
		changeProducer(denominations, incrementor + 1, change);

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
