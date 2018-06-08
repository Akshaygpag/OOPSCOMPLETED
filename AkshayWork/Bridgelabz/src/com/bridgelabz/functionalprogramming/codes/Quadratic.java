package com.bridgelabz.functionalprogramming.codes;


import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @since 17-05-2018
 * @version 1.0.0
 */
public class Quadratic {

	public static void main(String[] args) {
		// THIS MAIN METHOD WILL TAKE COEEF FOR THE EQUATION AND DELIGATE TASK TO
		// ROOTGENERATOR METHOD
		int a, b, c;
		try {
			System.out.println("Enter the coeff for the quadratic equation aX*X+bX+c");
			System.out.println("Coeff of X*X : ");
			a = Utility.getIntergerValue();
			System.out.println("Coeff of X : ");
			b = Utility.getIntergerValue();
			System.out.println("constant c  : ");
			c = Utility.getIntergerValue();
			System.out.format("The  two roots for the quqdratic equation   %dX*X+%d+X+%d\n", a, b, c);
			generateRoots(a, b, c);
		} catch (Exception e) {

		}

	}

	private static void generateRoots(int a, int b, int c) {
		// THIS METHOD GENERATES THE ROOTS FOR THE QUADRATIC EQUATION

		System.out.println("value of coeff are " + a + " " + b + " " + c);
		double delta = (b * b) - (4 * a * c);
		delta = Math.sqrt(delta);
		double root1, root2;
		root1 = (-b + delta) / (2 * a);
		root2 = (-b - delta) / (2 * a);
		System.out.println("The roots are X = " + root1 + " && X = " + root2);
	}

}
