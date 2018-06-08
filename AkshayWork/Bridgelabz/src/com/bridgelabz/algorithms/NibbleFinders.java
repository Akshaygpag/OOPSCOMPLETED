package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * FIND NIBBLES USING BINARY NUMBER AND GENERATE NEW NUMBER BY SWAPPING NIBBLES
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class NibbleFinders {

    public static void main(String[] args) {
	// THIS METHOD WILL BE USED CALL THE STATIC METHOD TO TAKE USER DECIAL VALUE AND
	// RETURN STRING OF CHARS WHICH CONTAINS THE BINARY REP OF THE DATA

	System.out.println("Enter the decimal value which is to be convered to binary");
	int decimal = Utility.getIntergerValue();// TAKES USER DECIMAL VALUE INT

	String binary = AlgorithmUtil.toBinary(decimal);// TOBINARY STATIC METHOD CALLED
	int i = 0;

	while (binary.charAt(i) == '0') {
	    i++;
	} // performing this to ensure that binary is padding is removed
	  // 000000000000000--10101010
	String data = binary.substring(i, binary.length());
	i = 0;

	List<String> nibbles = new ArrayList<String>();
	if (!(data.length() % 4 == 0)) {
	    // PREPPEND IT WITH 0
	    data = "0" + data;

	}

	// CAN BE EASILY DIVIDE INTO NIBBLES
	int k = i;

	while (i < data.length()) {
	    if ((i + 1) % 4 == 0) {
		String singleNibble = data.substring(k, i + 1);
		nibbles.add(singleNibble);
		k = i + 1;
	    }
	    i++;
	}

	String binaryToDecimal = toDecimal(nibbles.get(1).concat(nibbles.get(0)));
	System.out.println("decimal value is : " + binaryToDecimal);
    }

    private static String toDecimal(String concat) {
	// CONVERT FROM BINARY TO DECIMAL

	int len = concat.length() - 1;
	int result = 0;
	int i = 0;
	while (len >= 0) {

	    result = result + Integer.parseInt(String.valueOf(concat.charAt(len))) * (int) Math.pow(2, i);
	    len--;
	    i++;
	}

	return String.valueOf(result);
    }

}