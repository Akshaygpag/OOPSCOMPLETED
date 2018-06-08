package com.bridgelabz.functionalprogramming.codes;

import java.util.Scanner;


import com.bridgelabz.functionalprogramming.exceptions.GenericExceptions;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @since 17-05-2018
 *@version 1.0.0
 */
public class DistinctTriplets {
	private static int count;

	public static void main(String[] args) {
		// METHOD TAKES USER INPUT FOR THE NUMBER OF ARRAYS LENGTH AND THE ARRAY OF DATA

		Scanner scan = null;
		int length;
		try {
			System.out.println("Enter the length of array");
		 length=Utility.getIntergerValue();
			if (length < 3) {

				throw new GenericExceptions("Minimum number of elements required are 3...");
			}
			int array[] = Utility.setSingleIntArrayData(length);

			findDistinctTriplets(array);

		} catch (GenericExceptions e) {
		} catch (Exception e) {

		}
	}

	private static void findDistinctTriplets(int[] array) {
		// THIS METGHOD WILL PRODUCE DISTINCT THREE DIGITS OF NUMBERS FROM THE ARRAY
		// WHOSE SUM WILL BE EQYUAL TO 0

		for (int i = 0; i <=array.length - 3; i++) {

			for (int j = i + 1; j <=array.length - 2; j++) {

				for (int k = j + 1; k <= array.length - 1; k++) {

					if ((array[i] + array[j] + array[k]) == 0) {
						
						System.out.println("i : "+array[i]+"\tj : "+array[j]+"\tk : "+array[k]);
						count++;
					}

				}

			}

		}
		
		System.out.println("The number of comninations found are "+count);

	}

}
