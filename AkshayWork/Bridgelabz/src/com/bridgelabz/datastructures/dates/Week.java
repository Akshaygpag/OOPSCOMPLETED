package com.bridgelabz.datastructures.dates;

import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.datastructures.programs.Node;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */
public class Week implements Comparable<Week> {

    private final OrderedList daysInWeek = new OrderedListImpl();

    @Override
    public String toString() {
	daysInWeek.printElements();
	return null;
    }

    public OrderedList getDaysInWeek() {
	return daysInWeek;
    }

 /**
  * COMPARE 
  */
    @Override
    public int compareTo(Week o) {
	return 0;
    }

}
