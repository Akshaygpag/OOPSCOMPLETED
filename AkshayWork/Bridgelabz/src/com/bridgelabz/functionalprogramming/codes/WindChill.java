package com.bridgelabz.functionalprogramming.codes;

/**
 * @author Akshay
 * @since 17-05-2018
 * @version 1.0.0
 */
public class WindChill {

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE COMMAND LINE ARGS AND CALLEFFECTIVETEMP METHOD
	try {
	    System.out.println("Enters the method");

	    try {

		int t = Integer.parseInt(args[0]);
		int v = Integer.parseInt(args[1]);

		System.out.println("int value of t is : " + t);
		System.out.println("int value of v is : " + v);
		if (Math.abs(t) > 50 || (v > 120 && v < 3)) {
		    System.out.println("invalid inputs");

		    throw new Exception("T value below 50 and v value greater than 3 and less than 120");
		}
		generateEffecticeTemperature(t, v);
	    } catch (Exception e) {
		e.printStackTrace();

	    }
	    /*
	     * 
	     * 
	     * 
	     * 
	     */

	} catch (Exception e) {

	    System.out.println(e.getMessage());
	}

    }

    private static void generateEffecticeTemperature(int t, int v) {
	// USING THE FORMULA CREATE THE EFFECTIVE TEMPERATURE

	double w = 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * (Math.pow(v, 0.16));

	System.out.println("The effective temperature should be " + w + " degrees");

    }

}
