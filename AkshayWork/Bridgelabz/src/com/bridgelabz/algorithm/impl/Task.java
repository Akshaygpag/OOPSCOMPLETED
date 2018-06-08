/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */

package com.bridgelabz.algorithm.impl;

import java.util.Comparator;

/**
 * @author bridgeit
 *
 */
public class Task implements Comparator<Task> {
    private int id;
    private int time;
    private int endTime;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getTime() {
	return time;
    }

    public void setTime(int time) {
	this.time = time;
    }

    public int getEndTime() {
	return endTime;
    }

    @Override
    public String toString() {
	return "Task [id=" + id + ", time=" + time + ", endTime=" + endTime + "]";
    }

    public void setEndTime(int endTime) {
	this.endTime = endTime;
    }

    @Override
    public int compare(Task o1, Task o) {
	if (o1.getEndTime() > o.getEndTime()) {
	    return -1;
	} else {
	    return 0;
	}
    }

}
