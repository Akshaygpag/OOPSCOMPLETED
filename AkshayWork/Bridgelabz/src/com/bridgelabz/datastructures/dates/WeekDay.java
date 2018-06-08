/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */

package com.bridgelabz.datastructures.dates;

/**
 * @author bridgeit
 *
 */
public class WeekDay implements Comparable<WeekDay> {


    @Override
    public String toString() {
	return "WeekDay [day=" + day + ", date=" + date + "]";
    }

    private String day;
    private String date;

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getDay() {
	return day;
    }

    public void setDay(String day) {
	this.day = day;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(WeekDay o) {
	// bridgeit 
	return 0;
    }

}
