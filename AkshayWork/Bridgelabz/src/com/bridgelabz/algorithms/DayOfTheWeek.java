package com.bridgelabz.algorithms;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * FINDS THE DAY OF THE WEEK
 * 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */

public class DayOfTheWeek {
    enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FIRDAY, SATURDAY
    };

    public static void main(String[] args) {
	// THIS TAKES COOMAND LINE ARGS AND CALLS THE STATIC METHOD FROM UTILITY CLASS
	try {

	    Calendar calendar = new GregorianCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]) - 1,
		    Integer.parseInt(args[2]));

	    System.out.println(calendar.getTime());

	    System.out.println(
		    Integer.parseInt(args[0]) + " " + Integer.parseInt(args[1]) + " " + Integer.parseInt(args[2]));
	    System.out.println(calendar.get(Calendar.MONTH) + 1);

	    System.out.println(Integer.parseInt(args[1]));
	    if (calendar.get(Calendar.MONTH) + 1 != Integer.parseInt(args[1])) {

		throw new Exception("Enter valid date ....");
	    }

	    System.out.println(calendar.getTime() + " date is ");
	    int position = AlgorithmUtil.dayOfWeek(calendar.get(Calendar.DATE), calendar.get(Calendar.MONTH) + 1,
		    calendar.get(Calendar.YEAR));
	    System.out.println(Day(position) + " is the day of the week");
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    System.out.println("Exiting");
	    System.exit(1);

	}

    }

    private static com.bridgelabz.algorithms.DayOfTheWeek.Day Day(int i) {
	Day[] days = Day.values();
	return days[i];
    }

}
