package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * FIND PRIME NUMBERS IN THAT RANGE
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class PrimeNumbersRange {
    public static void main(String[] args) {
	// MAIN METHOD IS USED TO CALL THE UTILITY MEHTOD TO GET ALL PRIMES IN THE RANGE

	System.out.println("Enter the number between range 0-1000");
	int numberRange = Utility.getIntergerValue();
	if (numberRange > 1000 || numberRange < 0) {
	    System.out.println("range from 0 to 1000");
	    return;
	}
	Object[] allPrimeNumbers = AlgorithmUtil.findPrimeNumbers(numberRange);//FINDS ALL THE PRIME NUMBERS FOR THE RANGE

	for (Object x : allPrimeNumbers) {
	    System.out.print(x + " ");

	}

    }

}
