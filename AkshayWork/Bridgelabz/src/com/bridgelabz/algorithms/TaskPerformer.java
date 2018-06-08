/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.bridgelabz.algorithm.impl.QueueImpl;
import com.bridgelabz.algorithm.interfaces.Queue;

public class TaskPerformer {
    static int start = 0;

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {
	TaskProcess p1 = new TaskProcess();
	p1.arrivalTime = 0;
	p1.burstTime = 2;
	p1.deadLine = 31;

	TaskProcess p2 = new TaskProcess();
	p2.burstTime = 3;
	p2.arrivalTime = 2;
	p2.deadLine = 61;

	TaskProcess p3 = new TaskProcess();
	p3.burstTime = 6;
	p3.arrivalTime = 3;
	p3.deadLine = 91;

	TaskProcess p4 = new TaskProcess();
	p4.burstTime = 1;
	p4.arrivalTime = 3;
	p4.deadLine = 71;

	start = 0;
	// CHECK FOR ANY PROCESS WHICH IS AVAILABLE TO WORK WITH
	// IF SO ADD IT TO THE QUEUE
	Queue processHolder = new QueueImpl();
	List<TaskProcess> allTaskProcess = new ArrayList<TaskProcess>();
	allTaskProcess.add(p1);
	allTaskProcess.add(p2);
	allTaskProcess.add(p3);
	allTaskProcess.add(p4);
	Comparator<TaskProcess> sortItems = (o1, o2) -> {

	    if (o1.arrivalTime < o2.arrivalTime) {
		return -1;
	    } else if (o1.arrivalTime == o2.arrivalTime) {
		return 0;
	    } else {
		return 1;
	    }

	};

	allTaskProcess.sort(sortItems);
	ThreadQueueTaskAdder addTask = new ThreadQueueTaskAdder("Adder Thread");
	ThreadQueueTaskDoer dotas = new ThreadQueueTaskDoer("Doer Thread");
	while (processHolder.isEmpty()) {
	    
	    
	    
	    
	}

    }

}

class ThreadQueueTaskAdder extends Thread {
    public ThreadQueueTaskAdder(String name) {
	super(name);

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

    }

}

class ThreadQueueTaskDoer extends Thread {
    public ThreadQueueTaskDoer(String name) {
	super(name);

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

    }

}
