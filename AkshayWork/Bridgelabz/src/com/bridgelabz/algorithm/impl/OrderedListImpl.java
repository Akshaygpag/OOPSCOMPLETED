package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.datastructures.programs.Node;

public class OrderedListImpl<T extends Comparable<T>> implements OrderedList<T>, Cloneable {
    Node<T> first;

    public OrderedListImpl() {
	// ZERO ARGUMENT CONSTRUCTOR
	this.first = null;
    }

    @Override
    public OrderedList<T> list() {
	// CREATES THE ORDERED LIST WITH 0 SIZE
	System.out.println("Created an empty ordered list");
	return new OrderedListImpl<T>();
    }

    @Override
    public void add(Node item) {
	// ADDS THE ELEMENT TOT THE CORRECT POSITION DEPENDING ON THE NATURAL SORTING
	// ORDER

	if (first == null) {

	    first = item;

	    return;
	}
	if (item.getInfo().compareTo(first.getInfo()) <= 0) {
	    item.setNext(first);
	    first = item;

	    return;
	}

	Node<T> previous = first;
	Node<T> current = first;

	while (current != null) {
	    if (item.getInfo().compareTo(current.getInfo()) < 0) {
		break;
	    }
	    previous = current;
	    current = current.getNext();

	}
	previous.setNext(item);
	item.setNext(current);

    }

    @Override
    public boolean isEmpty() {
	// CHECKS IF THE LIST IS EMPTY OR NOT
	if (first != null) {
	    return false;
	}
	return true;
    }

    @Override
    public int size() {
	// FINDS OUT THE NUMBER OF ITEMS PRESENT IN THE LIST

	Node<T> iterator = first;

	int sizeCounter = 0;

	while (iterator != null) {
	    sizeCounter++;
	    iterator = iterator.getNext();
	}
	return sizeCounter;

    }

    @Override
    public int index(Node item) {
	// RETURNS THE RAEAL INDEX OF THE ELEMENT IF FOUND ELSE IT WILL RETURN -1
	if (first != null) {
	    int counter = 0;
	    Node<T> iterator = first;

	    while (iterator != null) {
		if (((T) item.getInfo()).compareTo(iterator.getInfo()) == 0) {

		    return counter;
		}
		counter++;
		iterator = iterator.getNext();
	    }

	}
	return -1;
    }

    @Override // yet to be tested
    public Node<T> pop() {

	if (first == null) {

	    System.out.println("No elements found list is empty");
	    return null;

	} else if (this.size() == 1) {
	    Node<T> returningNode = first;
	    first = null;
	    return returningNode;
	}

	else {
	    Node<T> iterator = first;
	    Node<T> previous = iterator;
	    Node<T> previousOfPrevious = previous;
	    while (iterator != null) {
		previousOfPrevious = previous;
		previous = iterator;
		iterator = iterator.getNext();
	    }
	    previousOfPrevious.setNext(null);
	    return previous;
	}

    }

    @Override
    public Node<T> pop(int position) {
	// DELETE THE ELEMENT AT THE SPECIFIED POSITION

	if (first == null) {
	    System.out.println("List is empty cannot be popped...");
	    return null;

	}
	if (position == 0) {
	    Node<T> item = first;
	    first = first.getNext();
	    item.setNext(null);
	    return item;
	}

	Node<T> previous = first;
	Node<T> current = first;
	Node<T> next = first;
	if (this.size() > position) {
	    while (position >= 0) {
		previous = current;
		current = next;
		next = next.getNext();
		position--;
	    }

	    previous.setNext(next);
	    return current;

	}
	System.out.println("Element position is invalid lack of elements present ..");
	return null;
    }

    @Override
    public void remove(Node item) {
	// REMOVES THE FIRST MATCHED ITEM
	if (this.size() == 0) {
	    System.out.println("List is empty");
	    return;

	}
	if (item.getInfo().compareTo(first.getInfo()) == 0) {

	    Node<T> temp = first;
	    temp = temp.getNext();
	    first.setNext(null);
	    first = temp;
	    return;
	}
	Node<T> iterator = first;
	Node<T> previous = iterator;
	boolean isFound = false;
	while (iterator != null) {
	    if ((iterator.getInfo().compareTo((T) item.getInfo())) == 0) {
		isFound = true;
		break;
	    }

	    previous = iterator;
	    iterator = iterator.getNext();
	}
	if (isFound) {

	    Node<T> next = iterator.getNext();
	    previous.setNext(next);
	    iterator.setNext(null);

	    return;
	}

	System.out.println("Element not found ...");
	return;

    }

    @Override
    public boolean search(Node item) {
	// RETURNS TRUE FOR THE METHOD IF THE ITEM IS PRESENT ELSE IT RETURNS FALSE
	Node<T> iterator = first;

	while (iterator != null) {
	    if (((T) item.getInfo()).compareTo(iterator.getInfo()) == 0) {

		return true;
	    }
	    iterator = iterator.getNext();
	}
	return false;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.algorithm.interfaces.OrderedList#printElements()
     */
    @Override
    public void printElements() {
	Node<T> current = first;
	while (current != null) {
	    current = current.getNext();
	}

    }

    public Object clone() throws CloneNotSupportedException {
	return super.clone();
    }

    public Node<T> get(int position) {
	Node<T> item = null;

	Node<T> current = first;
	if (position < this.size()) {
	    int counter = 0;
	    while (counter != position && current != null) {
		current = current.getNext();
		counter++;
	    }

	    item = current;

	}

	return item;

    }

}
