package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bridgelabz.functionalprogramming.util.Utility;
/**
 * vending machine generate changes
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class VendingMachine {
	private static long CHANGE;

	public static void main(String[] args) {
		// TAKES IN CHANGE THAT HAS TO BE RETURNED
		System.out.println("Enter the change you need ?");
		long changeRequested = Utility.getLongValue();

		CHANGE = changeRequested;
		Map<Integer, Integer> denomination = new HashMap<Integer, Integer>();

		switch (1) {

		case 1:
			if (changeRequested >= 1000) {
				int thousand = 1;
				while (changeRequested >= 1000) {
					changeRequested = changeRequested - 1000;
					denomination.put(1000, thousand);
					thousand++;
				}

			}
		case 2:
			if (changeRequested >= 500) {
				int fiveHundred = 1;
				while (changeRequested >= 500) {
					changeRequested = changeRequested - 500;
					denomination.put(500, fiveHundred);
					fiveHundred++;
				}

			}
		case 3:
			if (changeRequested >= 100) {
				int oneHundred = 1;
				while (changeRequested >= 100) {
					changeRequested = changeRequested - 100;
					denomination.put(100, oneHundred);
					oneHundred++;
				}

			}

		case 4:
			if (changeRequested >= 50) {
				int fifty = 1;
				while (changeRequested >= 50) {
					changeRequested = changeRequested - 50;
					denomination.put(50, fifty);
					fifty++;
				}

			}

		case 5:
			if (changeRequested >= 10) {
				int ten = 1;
				while (changeRequested >= 10) {
					changeRequested = changeRequested - 10;
					denomination.put(10, ten);
					ten++;
				}

			}

		case 6:

			if (changeRequested >= 5) {
				int five = 1;
				while (changeRequested >= 5) {
					changeRequested = changeRequested - 5;
					denomination.put(5, five);
					five++;
				}

			}
		case 7:
			if (changeRequested >= 2) {
				int two = 1;
				while (changeRequested >= 2) {
					changeRequested = changeRequested - 2;
					denomination.put(2, two);
					two++;
				}

			}

		case 8:
			if (changeRequested >= 1) {
				int one = 1;
				while (changeRequested >= 1) {
					changeRequested = changeRequested - 1;
					denomination.put(1, one);
					one++;
				}

			}
			break;
		default:
			System.out.println("-ve or 0 value entered ");
			break;
		}

		Set<Integer> keys = denomination.keySet();
		List<Integer> allDenoms = new ArrayList<Integer>(keys);
		Comparator<Integer> descendingSorter = (Integer a, Integer b) -> {

			if (a > b) {
				return -1;

			}

			else if (a == b) {

				return 0;

			} else {

				return 1;
			}

		};

		allDenoms.sort(descendingSorter);

		System.out.println("The denominations requested are");
		Formatter formatter = new Formatter();
		for (Integer k : allDenoms) {
			System.out.println(String.format("%-4d", k) + " X " + denomination.get(k));
		}
		System.out.println("Total amount =" + CHANGE);
	}

}