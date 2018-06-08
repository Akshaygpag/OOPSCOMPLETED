package com.bridgelabz.functionalprogramming.codes;

import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * 
 * @author Akshay
 * @since 17-05-2018
 * @version 1.0.0
 */
public class Permutation {

	public static void main(String[] args) {
		String name = "01234567";
		Utility.setString(name);
		// StringHelper.recurssivePermutation(0, name.length()-1);
		Utility.callRecurssive(0, name.length() - 1);

		Utility.iterativePermutation(0, name.length() - 1);

	}
	

}
