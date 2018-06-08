
package com.bridgelabz.datastructures.programs;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.algorithms.PrimeAnagramsAndPalindrome;
import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */
public class PrimeNumber2DAnagram {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	System.out.println("Range of numbers from 0 to 1000");

	List<Integer> allPrimeNumbers = new ArrayList<Integer>();

	for (int i = 0; i <= 1000; i++) {
	    if (AlgorithmUtil.isPrime(i)) {
		allPrimeNumbers.add(new Integer(i));
	    }
	}
	Integer[] primeInts = allPrimeNumbers.toArray(new Integer[allPrimeNumbers.size()]);
	List<Integer> allAnagrams = PrimeAnagramsAndPalindrome.findAnagramPrimes(primeInts);
	String[][] dimension2DArray = new String[2][allPrimeNumbers.size()];
	for (int i = 0; i < dimension2DArray.length - 1; i++) {
	    for (int j2 = 0; j2 < allPrimeNumbers.size(); j2++) {
		if (j2 == 0 || j2 == 1) {
		    dimension2DArray[i][j2] = "";
		    continue;
		}
		Integer primeNumber = new Integer(j2);

		if (AlgorithmUtil.isPrime(primeNumber)) {

		    if (!allAnagrams.contains(primeNumber)) {
			dimension2DArray[i][j2] = String.valueOf(j2);
		    } else {
			dimension2DArray[i][j2] = "";
		    }

		} else {
		    dimension2DArray[i][j2] = "";
		}

	    }
	}
	String[] primeStrings = new String[allAnagrams.size()];
	for (int i = 0; i < primeStrings.length; i++) {
	    primeStrings[i] = allAnagrams.get(i).toString();
	}
	for (int i = 0; i < dimension2DArray.length - 1; i++) {
	    for (int j = 0; j < dimension2DArray[i].length; j++) {
		if (dimension2DArray[i][j] == "") {
		    continue;
		}
		System.out.print(dimension2DArray[i][j] + "  ");
	    }
	    System.out.println();
	}
	dimension2DArray[1] = primeStrings;

	// ALL ITEMS ARE PUSHED
	int seperator = 0;
	// PRINTING THE NUMBERS IN REVERSE ORDER
	while (dimension2DArray[1].length > seperator) {// TILL THE STACK IS EMPTY POP
	    if (seperator != 0 && seperator % 2 == 0) {// IF THE NUMBERS ARE IN PAIR THEN SEPERATE THEM USING ","
		System.out.print(",");
	    }
	    StringBuffer reversingString = new StringBuffer(dimension2DArray[1][seperator].toString());// POP THE
												       // ELEMENTS
	    reversingString = reversingString.reverse();// CONVERTED STRING BUFFER IS REVERSED
	    System.out.print(reversingString + " ");// SPACE BETWEEN THE PAIR
	    seperator++;
	}

    }
}
