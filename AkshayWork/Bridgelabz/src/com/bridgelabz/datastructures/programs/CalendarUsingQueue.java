package com.bridgelabz.datastructures.programs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import com.bridgelabz.algorithm.impl.QueueImpl;
import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.datastructures.dates.Week;
import com.bridgelabz.datastructures.dates.WeekDay;

enum Days {
    S, M, T, W, Th, F, Sa
}

/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */
public class CalendarUsingQueue {
    static Map<Integer, Integer> days;
    static {
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

    /**
     * TAKES THE COMMMAND LINE ARGUMENTS AND CALLS THE DISPLAY METHOD
     * 
     * @param args
     * 
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
	// METHOD WILL TAKE COMMAND LINE ARG FOR MONTH AND YEAR AND PRODUCE CALENDAR
	// USING THE QUEUE

	Calendar calendarG = new GregorianCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]) - 1, 1);
	int date = calendarG.get(java.util.Calendar.DATE);
	int month = calendarG.get(java.util.Calendar.MONTH);
	int year = calendarG.get(java.util.Calendar.YEAR);
	int position = AlgorithmUtil.dayOfWeek(date, month + 1, year);
	boolean isLeapYear = false;
	if (calendarG.get(java.util.Calendar.MONTH) == 1) {
	    // CHECK FOR LEAP YEAR
	    isLeapYear = AlgorithmUtil.leapChecker(Long.parseLong(args[0]));
	    if (isLeapYear) {
		days.put(1, 29);
	    }
	}
	int end = days.get(calendarG.get(month));
	Queue<Week> queue = new QueueImpl<Week>();
	// ADDING THE DAYS TO THE QUEUE
	Week labels = new Week();
	for (int i = 0; i < DAYS.values().length; i++) {
	    WeekDay day = new WeekDay();
	    day.setDate("");
	    day.setDay(DAYS.values()[i].toString());
	    Node addingDay = new Node();
	    addingDay.setInfo(day);
	    labels.getDaysInWeek().add(addingDay);
	}
	// ADDED THE DAYS
	Node<Week> headerlables = new Node<Week>();
	headerlables.setInfo(labels);
	queue.enqueue(headerlables);
	// ADDING THE DATES
	int start = 1;
	for (int i = 0; i < 7 && start <= end; i++) {
	    // MAX NUMBER OF ROWS IN A CALENDAR
	    Week week = new Week();
	    for (int j = 0; j < Days.values().length && start <= end; j++) {
		// WHERE 0 IS SUNDAY
		if (j < position && i == 0) {
		    WeekDay daysToAdd = new WeekDay();
		    daysToAdd.setDate("");
		    daysToAdd.setDay("");
		    Node dayNode = new Node();
		    dayNode.setInfo(daysToAdd);
		    week.getDaysInWeek().add(dayNode);
		    continue;
		}
		WeekDay daysToAdd = new WeekDay();
		daysToAdd.setDate(String.valueOf(start++));
		daysToAdd.setDay("");
		Node dayNode = new Node();
		dayNode.setInfo(daysToAdd);
		week.getDaysInWeek().add(dayNode);
	    }
	    Node wholeWeek = new Node();
	    wholeWeek.setInfo(week);
	    queue.enqueue(wholeWeek);

	}
	System.out.println("\n");
	System.out.println("% java Calendar " + (calendarG.get(month) + 1) + " " + args[0] + " "
		+ getMonths(calendarG.get(month)));
	System.out.println("-------------------------------");
	displayCalendar(queue);
	
	
    }


    /**
     * @param queue
     * 
     */
    private static void displayCalendar(Queue<Week> queue) {

	    
	    int queueSize = queue.size();
		while (!queue.isEmpty()) {

		    Node<Week> week = queue.dequeue();

		    Week weekOne =  week.getInfo();

		    if (queueSize - 1 == queue.size()) {// IT IS FOR PRINTING THE DAYS

			while (!weekOne.getDaysInWeek().isEmpty()) {
			    WeekDay dateInCalendar = (WeekDay) weekOne.getDaysInWeek().pop().getInfo();
			    System.out.print(String.format("%4s", dateInCalendar.getDay()));
			}
			System.out.println();

		    }
		    else {//IT IS FOR PRINTING THE DATES
			while (!weekOne.getDaysInWeek().isEmpty()) {
			    WeekDay dateInCalendar = (WeekDay) weekOne.getDaysInWeek().pop().getInfo();
			    System.out.print(String.format("%4s", dateInCalendar.getDate()));
			}
			System.out.println();
		    }
		}
		System.out.println("-------------------------------");
	    
	}



    static String getMonths(int month) {
	Months[] months = Months.values();
	return months[month].name();

    }
}
