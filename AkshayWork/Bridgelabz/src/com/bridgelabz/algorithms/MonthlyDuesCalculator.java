package com.bridgelabz.algorithms;

import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * FIND THE MINIMUM MONTHLY AMOUNT HAS TO BE PAID
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class MonthlyDuesCalculator {

    public static void main(String[] args) {
	// TAKES THE COMMAND LINE ARGS AND THEN CALCULATES THE MONTHLY PAYMENTS

	double y, p, r;
	y = Double.parseDouble(args[0]);
	p = Double.parseDouble(args[1]);
	r = Double.parseDouble(args[2]);

	AlgorithmUtil.monthlyPayment(p, y, r);

    }

}
