
package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */
public class PrimeNumberIn2DArray {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	int[][] primeNumbersArray = new int[10][100];
	int[] counters = new int[10];
	System.out.println("The range of numbers are from 0-1000");

	int index = -1;

	for (int i = 0; i <= 1000; i++) {

	    if (AlgorithmUtil.isPrime(i)) {
		index = i / 100;
		primeNumbersArray[index][counters[index]++] = i;

	    }
	}
	for (int i = 0; i < primeNumbersArray.length; i++) {
	    for (int j = 0; j < counters[i]; j++) {
		if (primeNumbersArray[i][j] == 0) {
		    continue;
		}
		String dataPrint = String.format("%-6d", primeNumbersArray[i][j]);
		System.out.print(dataPrint);
	    }
	    System.out.println();
	}
    }
}
