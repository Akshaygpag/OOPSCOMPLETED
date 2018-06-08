package com.bridgelabz.datastructures.programs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.bridgelabz.algorithm.impl.Task;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */


public class TaskCompleting {

    public static void main(String[] args) {
	System.out.println("Starting task.......");
	Task t1 = new Task();
	t1.setId(1);
	t1.setTime(4);
	t1.setEndTime(3);
	Task t2 = new Task();
	t2.setId(2);
	t2.setTime(3);
	t2.setEndTime(3);

	Task t3 = new Task();
	t3.setId(3);
	t3.setTime(5);
	t3.setEndTime(6);

	Task t4 = new Task();
	t4.setId(4);
	t4.setTime(6);
	t4.setEndTime(7);

	Task t5 = new Task();
	t5.setId(5);
	t5.setTime(4);
	t5.setEndTime(9);

	Task t6 = new Task();
	t6.setId(6);
	t6.setTime(9);
	t6.setEndTime(3);

	Task t7 = new Task();

	t7.setId(7);
	t7.setTime(1);
	t7.setEndTime(10);
	// ENTERED ALL THE TASKS

	List<Task> allTasks = new ArrayList<Task>();
	allTasks.add(t1);
	allTasks.add(t2);
	allTasks.add(t3);
	allTasks.add(t4);
	allTasks.add(t5);
	allTasks.add(t6);
	allTasks.add(t7);

	Comparator<Task> descendingSorter = (Task a, Task b) -> {

	    if (a.getEndTime() > b.getEndTime()) {
		return 1;

	    }

	    else if (a.getEndTime() == b.getEndTime()) {
		if (a.getTime() >= b.getTime()) {

		    return 1;
		} else {

		    return -1;

		}

	    } else {

		return -1;
	    }

	};// CREATED THE LAMBDA EXPRESSION FOR THE COMPARING AND SORTING IN DESCENDING
	  // ORDER

	allTasks.sort(descendingSorter);
	for (Task s : allTasks) {
	    System.out.println(s);
	}
	
    }
}
