package com.bridgelabz.functionalprogramming.codes;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Akshay
 * @since 17-05-2018
 * @version 1.0.0
 */
public class StopWatch {

	public static void main(String[] args) {
		// USER DATA FOR START AND END
		Scanner scan = null;
		String start, end;

		try {
			scan = new Scanner(System.in);
			System.out.println("Enter start ");
			start = scan.nextLine();
			Date startDate = new Date();
			System.out.println("Enter end ");
			end = scan.nextLine();

			Date endDate = new Date();

			System.out.println((double) (endDate.getTime() - startDate.getTime()) / 1000 + " seconds");
		} catch (Exception w) {
			System.out.println(w.getMessage());
		}

	}

}

/*
 * System.out.println(endDate.getTime() - startDate.getTime());
 * 
 * System.out.println(new Date(endDate.getTime() - startDate.getTime()));
 * 
 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss"); String
 * res = simpleDateFormat.format(new Date(endDate.getTime() -
 * startDate.getTime()));
 * 
 * System.out.println(res);
 * 
 */
