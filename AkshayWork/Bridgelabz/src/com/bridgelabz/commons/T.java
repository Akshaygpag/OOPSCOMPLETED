/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.commons;

public class T<E extends Comparable<E>> {
    private E data;

    public E getData() {
	return data;
    }

    public void setData(E data) {
	this.data = data;
    }

}
