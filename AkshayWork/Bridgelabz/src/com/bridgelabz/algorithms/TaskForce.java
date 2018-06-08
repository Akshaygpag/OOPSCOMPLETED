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
import com.bridgelabz.datastructures.programs.Node;

public class TaskForce {
    static int start = 0;
    private static final int QUANT = 1;

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	TaskProcess p1 = new TaskProcess();
	p1.arrivalTime = 31;
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
	for (TaskProcess taskProcess : allTaskProcess) {

	    System.out.println(taskProcess);
	}

	System.out.println("--------------------");
	
	while(start!=allTaskProcess.get(0).arrivalTime) {
	    
	    start++;
	    
	    
	}
	for (TaskProcess taskProcess : allTaskProcess) {
	    if (start == taskProcess.arrivalTime) {

		Node node = new Node();
		node.setInfo(taskProcess);
		processHolder.enqueue(node);

		
	    }
	}

	
	// ONCE ALL THE TASK HAVE BEEN ADDED TO THE QUEUE

	while (!processHolder.isEmpty()) {// ASSUMING ATLEAST ONE TASK WILL BE AT 0
	
	    Node process = processHolder.dequeue();
	    TaskProcess task = (TaskProcess) process.getInfo();
	    if (task.deadLine > start && task.completedTime < task.burstTime) {

		// PERFORM THE TASK
		task.completedTime += QUANT;
		start += QUANT;
		task.waitingTime = start - task.arrivalTime - task.burstTime;
		task.turnAroundTime = start - task.arrivalTime;

		System.out.println("Start is : "+start+"   "+task);
		
		    for (TaskProcess taskProcess : allTaskProcess) {
			if (start == taskProcess.arrivalTime) {
			    Node node = new Node();
			    node.setInfo(taskProcess);
			    processHolder.enqueue(node);
			}
		    }
		if (task.deadLine > start) {

		    // ADD THE PROCESS BACK TO THE QUEUE
		    process.setInfo(task);
		    // TO BE SURE
		    processHolder.enqueue(process);
		}
	    }
	}
	double awt = 0.0;
	double atat = 0.0;
System.out.println("-------------");
	for (TaskProcess taskProcess : allTaskProcess) {
	    System.out.println(taskProcess);
	    awt += taskProcess.waitingTime;
	    atat += taskProcess.turnAroundTime;
	}

	System.out.println("The avg waiting time is : " + (awt / allTaskProcess.size()));
	System.out.println("The avg turn around time is : " + (atat / allTaskProcess.size()));

    }

}
