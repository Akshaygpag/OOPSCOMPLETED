package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * CHECK IT IS A ANAGRAM OR NOT
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class Anagram {

    public static void main(String[] args) {
	// MAIN METHOD USED FOR GETTING TWO STRINGS AS INPUT AND CHECK FOR ANAGRAM AND
	// DISPLAY APPROPRIATE MESSAGE
	System.out.println("Anagram checker program");
	System.out.println("Enter first value ");
	String first = Utility.getUserStringValue();
	System.out.println("Enter second value ");
	String second = Utility.getUserStringValue();
	String response = AlgorithmUtil.isAnagram(first, second);
	System.out.println(response);
    }

}
