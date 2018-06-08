package com.bridgelabz.functionalprogramming.codes;

import java.io.PrintWriter;

import java.util.Scanner;

import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @since 17-05-2018
 * @version 1.0.0
 */
public class TwoDArrayPrinter {

	public static void main(String[] args) {
		// TTAKES ROWS AND COLUMNS FOR THE 2D ARRAY
		int row, col;
		Scanner scan = null;
		Object matrix[][] = null;
		try {
			System.out.println("Enter the number of rows ");
			scan = new Scanner(System.in);
			row = scan.nextInt();
			System.out.println("Enter the number of cols ");
			col = scan.nextInt();

			matrix = Utility.setArrayData(row, col);

			printMatrix(matrix);

		} catch (Exception e) {
		e.printStackTrace();
		}

	}

	private static void printMatrix(Object[][] matrix) {
		StringBuffer sb = new StringBuffer();
		System.out.println("\tThe array in matrix is here is ");
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {

				sb.append("\t" + matrix[i][j] + " ");

			}
			sb.append("\n");

		}

		PrintWriter printWriter = new PrintWriter(System.out);
		printWriter.write(sb.toString());
		printWriter.flush();

	}

}
