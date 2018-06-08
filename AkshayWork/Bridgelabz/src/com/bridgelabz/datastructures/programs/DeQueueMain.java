
package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.DeQueImpl;
import com.bridgelabz.algorithm.interfaces.DeQue;
import com.bridgelabz.algorithm.interfaces.UtilInterface;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 24-May-2018
 */
public class DeQueueMain {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {
	// THIS METHOD WILL TAKE IN THE STRING VALUE FROM THE USER AND CHECK FOR
	// PALINDROME
	String userString = null;
	DeQue<Character> deQueu = null;
	Character[] UserStringToCharArray = null;
	try {

	    System.out.println("Enter the string to check for palindrome");
	    userString = Utility.getUserStringValue();

	    System.out.println("Entered string value is : " + userString);
	    deQueu = new DeQueImpl<Character>();// CREATED AN EMPTY DEQUEUE

	    char[] charArray = userString.toCharArray();

	    UserStringToCharArray = new Character[charArray.length];
	    for (int i = 0; i < charArray.length; i++) {
		UserStringToCharArray[i] = charArray[i];
	    }

	    for (Character c : charArray) {
		Node<Character> item = new Node<Character>();
		item.setInfo(c);
		deQueu.addRear(item);

	    }
	    boolean result = checkForpalinDrome(UserStringToCharArray, deQueu);
	    String palindrome = result ? UtilInterface.ISPALINDROME : UtilInterface.ISNOTPALINDROME;
	    System.out.println("The string is" + palindrome);
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }

    /**
     * @param userStringToCharArray
     * @return
     * 
     */
    private static boolean checkForpalinDrome(Character[] userStringToCharArray, DeQue<Character> deQueu) {
	// THIS METHOD WILL CALCULATE THE VALUE AND RETURN IF ITS PALINDROME
	int low = 0;
	int high = userStringToCharArray.length - 1;
	int mid = (low + high) / 2;
	int iterateTill = 0;

	if (userStringToCharArray.length % 2 == 0) {

	    iterateTill = mid;

	} else {
	    iterateTill = mid - 1;

	}

	while (low <= iterateTill) {

	    if ((deQueu.removeRear().getInfo().compareTo(deQueu.removeFront().getInfo())) != 0) {
		System.out.println("elements are not equal");
		return false;
	    }
	    low++;
	    high--;
	}

	return true;
    }

}
