/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.algorithms;

/**
 * @author bridgeit
 *
 */
public class TaskProcess implements Comparable<TaskProcess> {



    @Override
    public String toString() {
	return "TaskProcess [waitingTime=" + waitingTime + ", completedTime=" + completedTime + ", turnAroundTime="
		+ turnAroundTime + ", arrivalTime=" + arrivalTime + ", deadLine=" + deadLine + ", burstTime="
		+ burstTime + "]";
    }
    // int id;
    int waitingTime;
    int completedTime;
    int turnAroundTime;
    int arrivalTime;
    int deadLine;
    int burstTime;
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TaskProcess o) {
	// bridgeit 
	return 0;
    }



}
