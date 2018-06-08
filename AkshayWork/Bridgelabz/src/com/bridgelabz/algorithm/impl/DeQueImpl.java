/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.DeQue;
import com.bridgelabz.datastructures.programs.Node;

public class DeQueImpl<T extends Comparable<T>> implements DeQue<T> {

    Node<T> front;
    Node<T> rear;

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#Deque()
     */
    @Override
    public DeQue<T> Deque() {
	// RETURNS THE EMPTY DEQUEUE
	return new DeQueImpl<T>();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#addFront(com.bridgelabz.
     * datastructures.programs.Node)
     */
    @Override
    public void addFront(Node item) {
	// ADDS THE ELEMENT TO THE FRONT

	if (front == null && rear == null) {

	    rear = item;
	    front = item;
	    return;
	}

	front.setNext(item);
	front = item;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#addRear(com.bridgelabz.
     * datastructures.programs.Node)
     */
    @Override
    public void addRear(Node item) {
	// ADDS THE ELEMENT TO THE REAR

	if (front == null && rear == null) {

	    rear = item;
	    front = item;
	    return;
	}

	item.setNext(rear);
	rear = item;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#removeFront()
     */
    @Override
    public Node<T> removeFront() {
	// REMOVES THE ELEMENT FROM THE FRONT OF THE DEQUEUE
	if (front == null) {

	    return null;
	}
	Node<T> current = rear;
	Node<T> previous = rear;
	if (rear == front) {
	    Node<T> item = front;
	    rear = null;
	    front = null;
	    return item;
	}
	while (current != front) {
	    previous = current;
	    current = current.getNext();
	}
	front = previous;
	previous.setNext(null);
	return current;
    }

    @Override
    public Node<T> getFront() {
	return front;
    }

    public void setFront(Node front) {
	this.front = front;
    }

    @Override
    public Node<T> getRear() {
	return rear;
    }

    public void setRear(Node rear) {
	this.rear = rear;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#removeRear()
     */
    @Override
    public Node<T> removeRear() {
	// REMOVES THE ELEMENT FROM THE REAR
	if (rear == null) {

	    return null;

	}
	Node<T> current = rear;
	rear = rear.getNext();
	current.setNext(null);
	if (rear == null) {

	    front = null;
	}

	return current;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#isEmpty()
     */
    @Override
    public boolean isEmpty() {
	// RETURNS TRUE IF DEQUEUE IS EMPTY ELSE FALSE

	if (rear == null && front == null) {

	    return true;

	}

	return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.DeQue#size()
     */
    @Override
    public int size() {
	// GIVES THE SIZE OF THE DEQUEUE (NO OF ELEMENTS PRESENT IN IT)

	int size = 0;
	if (rear == null && front == null) {

	    return size;
	}
	Node<T> current = rear;

	while (current != null) {

	    size++;
	    current = current.getNext();

	}
	return size;
    }

}
