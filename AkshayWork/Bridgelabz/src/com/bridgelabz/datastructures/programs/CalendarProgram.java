package com.bridgelabz.datastructures.programs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import com.bridgelabz.algoritms.util.AlgorithmUtil;

enum DAYS {
    S, M, T, W, Th, F, Sa
}

enum Months {

    January, February, March, April, May, June, July, August, September, October, November, December

}

/**
 * PRINTS THE CALENDAR FOR THE MONTH AND YEAR ENTERED USING COMMANDLINE
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */
public class CalendarProgram {
    static Map<Integer, Integer> days;// CREATES DAYS REFERENCES
    static {// MONTH ENDS READY AT START
	days = new HashMap<Integer, Integer>();
	days.put(0, 31);
	days.put(1, 28);
	days.put(2, 31);
	days.put(3, 30);
	days.put(4, 31);
	days.put(5, 30);
	days.put(6, 31);
	days.put(7, 31);
	days.put(8, 30);
	days.put(9, 31);
	days.put(10, 30);
	days.put(11, 31);
    }

    public static void main(String[] args) {
	int[][] calendar = new int[7][7];
	Calendar calendarG = new GregorianCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]) - 1, 1);
	int date = calendarG.get(java.util.Calendar.DATE);
	int month = calendarG.get(java.util.Calendar.MONTH);
	int year = calendarG.get(java.util.Calendar.YEAR);
	int position = AlgorithmUtil.dayOfWeek(date, month + 1, year);
	int counterDates = 0;
	if (calendarG.get(java.util.Calendar.MONTH) == 1) {// MONTH IS FEB
	    // CHECK FOR LEAP YEAR
	    boolean isLeapYear = AlgorithmUtil.leapChecker(Long.parseLong(args[0]));
	    if (isLeapYear) {
		days.put(1, 29);// IF LEAP YEAR MAKE END DATE FOR FEB AS 29
	    }
	}
	System.out.println("% java Calendar " + (month + 1) + " " + args[0] + " " + getMonths(month));
	int end = days.get(month);
	for (int i = 0; i < calendar.length; i++) {
	    for (int j = 0; j < calendar[i].length; j++) {
		if (i == 0) {
		    calendar[i][j] = getDays()[j].name().charAt(0);
		    String formatDate = String.format("%-2s  ", String.valueOf((char) calendar[i][j]));
		    System.out.print(formatDate);
		    if (j == calendar[i].length - 1) {
			System.out.println();
		    }
		} else if (i == 1) {

		    if (j < position) {
			String formatDate = String.format("%-2s  ", " ");
			System.out.print(formatDate);
		    } else {
			calendar[i][j] = counterDates += 1;
			String formatDate = String.format("%-2d", calendar[i][j]);
			System.out.print(formatDate + "  ");

		    }

		} else {

		    if (end > counterDates) {
			calendar[i][j] = counterDates += 1;
			String formatDate = String.format("%-2d", calendar[i][j]);
			System.out.print(formatDate + "  ");
		    }
		}
	    }
	    System.out.println();
	}
    }

    /**
     * TO GET THE DAYS ARRAY
     * 
     * @return
     *
     */
    private static DAYS[] getDays() {
	DAYS[] days = DAYS.values();
	return days;
    }

    /**
     * GET THE MONTH NAME IS WORDS FOR THE NUMBER
     * 
     * @param month
     * @return
     *
     */
    static String getMonths(int month) {
	Months[] months = Months.values();
	return months[month].name();
    }

}
