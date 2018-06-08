package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bridgelabz.algorithm.impl.Task;

/**
 * COMPLETE AS MANY TASK AS POSSIBLE
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */

/**
 * THIS CLASS WILL BE USED TO CREATE A TASK AND HAS THE FIELDS ID,TIME,ENDTIME
 */

/**
 * THIS CLASS IS TASKACHIEVER TO TAKE THE TASK AND FIND THE MOST COMPLETABLES
 * TASKS WITH IN THE DEADLINE
 */
public class TaskAchiever {

    public static void main(String[] args) {
	// COMPLETE AS MANY TASK AS
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
	int startTime = 0;
	// ENTERED ALL THE TASKS

	Task[] tasks = { t1, t2, t3, t4, t5, t6, t7 };// STORING THE TASK IN ARRAY
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
	int max = 0;
	int id = 0;
	for (int i = 0; i < tasks.length; i++) {
	    if (i == 0) {
		max = tasks[i].getEndTime();
		id = tasks[i].getId();

	    }
	    if (max < tasks[i].getEndTime()) {

		max = tasks[i].getEndTime();
		id = tasks[i].getId();
	    }

	}
	System.out.println("----------------------------");
	int taskTime = 0;
	int index = 0;
	int endTime = 0;

	while (startTime <= max && index < allTasks.size()) {
	    Task task = allTasks.get(index++);
	    if ((task.getEndTime() > task.getTime()) && ((startTime + task.getTime()) <= task.getEndTime())) {
		System.out.println("selected " + task);
		taskTime = task.getTime();
		endTime = task.getEndTime();
	    }

	    if ((taskTime + startTime) <= endTime) {
		startTime = taskTime + startTime;
	    }

	}

    }
}