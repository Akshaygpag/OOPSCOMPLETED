package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * FIND BINARY REPRESENTATION OF THE DECIMAL NUMBER
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class DecimalToBinary {
    public static void main(String[] args) {
	System.out.println("Enter the decimal value which is to be convered to binary");
	int decimal = Utility.getIntergerValue();

	String binary = AlgorithmUtil.toBinary(decimal);

	System.out.println("The binary reprentation of the dcimal value : " + decimal + " is  : " + binary);
    }
}
