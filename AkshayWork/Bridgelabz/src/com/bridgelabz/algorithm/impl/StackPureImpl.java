
package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.Stack;
import com.bridgelabz.datastructures.programs.Node;

/**
 * IMPLEMENTATION OF THE STACK USING LINKED LIST
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */
public class StackPureImpl<T extends Comparable<T>> implements Stack<T> {
    private Node<T> top;// TOP REFERENCES THE TOP MOST ELEMENT IN THE STACK NULL|NOT NULL

    public Node<T> getTop() {// GETTER METHOD FOR THE TOP
	return top;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setTop(Node top) {// SETTER METHOD FOR THE TOP
	this.top = top;
    }

    /**
     * CREATES AN EMPTY STACK WITH TOP POINTING TO NULL
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Stack stack() {
	// STACK() RETURNS THE UPCASTED OBJECT FOR THE STACK IMPLEMENTATION
	return new StackPureImpl();
    }

    /**
     * REMOVES THE TOP MOST ELEMENT
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Node<T> pop() {
	// RETURNS THE TOP MOST ELEMENT AND TOP POINTS TO NEXT LOWER ELEEMTN
	// TOP=NULL|NODE
	if (top != null) {
	    Node returningNode = top;
	    top = top.getNext();
	    return returningNode;

	}

	return null;
    }

    /**
     * PEEK METHOD GETS THE INFO OF THE TOP MOST ELEMENT IN THE STACK WOI
     */
    @Override
    public Node<T> peek() {
	if (top != null) {
	    return top;

	}
	return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.Stack#isEmpty()
     */
    @Override
    public boolean isEmpty() {
	if (top == null) {
	    return true;
	}
	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.Stack#size()
     */
    @SuppressWarnings("unchecked")
    @Override
    public int size() {
	int size = 0;
	Node<T> current = top;
	while (current != null) {
	    size++;

	    current = current.getNext();
	}
	return size;

    }

    /**
     * PUSHES THE ELEMENT INTO THE STACK
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void push(Node item) {
	// ADDS THE EMENT INTO STACK AND INCREMENTS THE TOP VALUE TO POINT TO NEW
	// ELEMENT
	item.setNext(top);
	top = item;

    }

}
