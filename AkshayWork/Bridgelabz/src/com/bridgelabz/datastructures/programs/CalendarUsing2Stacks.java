package com.bridgelabz.datastructures.programs;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.datastructures.dates.Week;
import com.bridgelabz.datastructures.dates.WeekDay;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */
public class CalendarUsing2Stacks {
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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
	// METHOD WILL TAKE COMMAND LINE ARG FOR MONTH AND YEAR AND PRODUCE CALENDAR
	// USING THE QUEUE
	Calendar calendarG = new GregorianCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]) - 1, 1);
	int date = calendarG.get(java.util.Calendar.DATE);
	int month = calendarG.get(java.util.Calendar.MONTH);
	int year = calendarG.get(java.util.Calendar.YEAR);
	int position = AlgorithmUtil.dayOfWeek(date, month + 1, year);
	if (calendarG.get(java.util.Calendar.MONTH) == 1) {// MONTH IS FEB
	    // CHECK FOR LEAP YEAR
	    boolean isLeapYear = AlgorithmUtil.leapChecker(Long.parseLong(args[0]));
	    if (isLeapYear) {
		days.put(1, 29);// IF LEAP YEAR MAKE END DATE FOR FEB AS 29
	    }
	}
	int end = days.get(month);
	QueueUsingStack<Week> queue = new QueueUsingStack<Week>();
	// ADDING THE DAYS TO THE QUEUE
	Week labels = new Week();// OBJECT TO STORE DAYS OBJECTS
	for (int i = 0; i < DAYS.values().length; i++) {
	    Node addingDay = new Node();// CREATE NODE TO STORE DAYS
	    WeekDay day = new WeekDay();// CREATED DAY OBJECT AND SET VALUES
	    day.setDate("");
	    day.setDay(DAYS.values()[i].toString());
	    addingDay.setInfo(day);
	    labels.getDaysInWeek().add(addingDay);// ADD THE DAY TO THE WEEK USING ORDERED LINKED LIST
	}
	// ADDED THE DAYS
	Node<Week> headerlables = new Node<Week>();// CREATE A NODE FOR THE DAYS TO BE IN MONTH
	headerlables.setInfo(labels);// SET THE WEEK OBJECT TO THE NODE
	queue.enqueue(headerlables);// PUSH THE WEEK OBJECT INTO THE QUEUE

	// ADDING THE DATES
	int start = 1;
	for (int i = 0; i < 7 && start <= end; i++) {// MAX NUMBER OF ROWS IN A CALENDAR
	    Week week = new Week();// CREATE A WEEK OBJECT
	    for (int j = 0; j < Days.values().length && start <= end; j++) {// THIS ITERATION RUNS FROM SUNDAY TO
									    // SATURDAY
		// WHERE 0 IS SUNDAY
		if (j < position && i == 0) {// FINDING THE VALID STARTING
		    WeekDay daysToAdd = new WeekDay();// CREATE EMPTY DATES WITH "" STRING
		    daysToAdd.setDate("");
		    daysToAdd.setDay("");
		    Node<WeekDay> dayNode = new Node<WeekDay>();
		    dayNode.setInfo(daysToAdd);
		    week.getDaysInWeek().add(dayNode);// ADD TO THE WEEK
		    continue;
		}
		WeekDay daysToAdd = new WeekDay();
		daysToAdd.setDate(String.valueOf(start));
		start += 1;
		daysToAdd.setDay("");
		Node<WeekDay> dayNode = new Node<WeekDay>();
		dayNode.setInfo(daysToAdd);
		week.getDaysInWeek().add(dayNode);
	    }
	    Node<Week> wholeWeek = new Node<Week>();
	    wholeWeek.setInfo(week);
	    queue.enqueue(wholeWeek);// ADD THE WEEK TO THE QUEUE
	}
	System.out.println("% java Calendar " + (month + 1) + " " + args[0] + " " + getMonths(month));
	displayCalendar(calendarG, queue, month, year);
    }

    /**
     * HELPS IN DISPLAYING THE CALENDAR VALUE IN FORMAT
     * 
     * @param calendarG
     * @param queue
     * @param year
     * @param month
     *
     */
    private static void displayCalendar(Calendar calendarG, QueueUsingStack<Week> queue, int year, int month) {
	System.out.println("-------------------------------");
	int queueSize = queue.size();
	while (!queue.isEmpty()) {
	    Node<Week> week = queue.dequeue();
	    Week weekOne = week.getInfo();
	    if (queueSize - 1 == queue.size()) {
		while (!weekOne.getDaysInWeek().isEmpty()) {
		    WeekDay dateInCalendar =  (WeekDay) weekOne.getDaysInWeek().pop().getInfo();
		    System.out.print(String.format("%4s", dateInCalendar.getDay()));
		}
		System.out.println();
	    } else {
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
