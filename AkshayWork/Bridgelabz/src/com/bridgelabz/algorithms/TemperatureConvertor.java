package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * CONVERT TEMPERATURE FROM CELCIUS TO FARANITE AND VICE VERSA
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class TemperatureConvertor {

	public static void main(String[] args) {
	    // THIS METHOD WILL ALLOW USER TO SELECT THE TEMPERATURE SCALE AND ENTER THE TEMPERATURE THAT IS TO BE CONVERTED INTO THE SCALE THAT IS SPECIFIED
		char symbol = ' ';
		
		//remain
		while (true) {
			System.out.println("How to convert");
			System.out.println("1.To Faranite");
			System.out.println("2.To Celcius");
			int value = Utility.getIntergerValue();

			if (value == 1) {
				symbol = 'F';//CONVERT TO F

			} else if (value == 2) {
				symbol = 'C';//CONVERT TO C
			} else {
				System.out.println("Invalid Inputs ");//NEITHER F OR C IS SELECTED 
				System.exit(1);

			}
			System.out.println("Enter the temperature to convert");
			double temp = Utility.getDoubleValue();//USER INPUT
			AlgorithmUtil.temperaturConversion(symbol, temp);//CALL THE METHOD TO DISPLAY THE CONVERTED TEMP

		}

	}

}
