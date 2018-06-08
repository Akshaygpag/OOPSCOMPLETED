package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.List;
import com.bridgelabz.datastructures.programs.Node;

@SuppressWarnings("rawtypes")
public class UnOrderedList<T extends Comparable<T>> implements List<T> {
    Node<T> first;

    @Override
    public UnOrderedList list() {
	System.out.println("Returning an empty list");
	return new UnOrderedList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void add(Node item) {
	if (first == null) {
	    first = item;
	} else {
	    /*
	     * Node iterator = first; Node previous = iterator; while (iterator != null) {
	     * previous = iterator; iterator = iterator.getNext(); } previous.setNext(item);
	     */
	    item.setNext(first);
	    first = item;
	}

    }

    @SuppressWarnings("unchecked")
    @Override
    public Node remove(Node item) {
	// REMOVES THE FIRST MATCHED ITEM
	if (first == null) {
	    System.out.println("List is empty");
	    return null;
	}
	if ((first.getInfo().compareTo((T) item.getInfo())) == 0) {
	    Node temp = first;
	    temp = temp.getNext();
	    first.setNext(null);
	    first = temp;
	    return item;
	}
	Node iterator = first;
	Node previous = iterator;
	while (iterator != null) {
	    if ((item.getInfo().compareTo(iterator.getInfo())) == 0) {
		System.out.println("match found removing the element");
		break;
	    }

	    previous = iterator;
	    iterator = iterator.getNext();
	}

	Node next = iterator.getNext();
	previous.setNext(next);
	iterator.setNext(null);
	return iterator;

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean search(Node item) {
	// RETURNS TRUE FOR THE METHOD IF THE ITEM IS PRESENT ELSE IT RETURNS FALSE
	Node iterator = first;

	while (iterator != null) {
	    if ((iterator.getInfo().compareTo(item.getInfo())) == 0) {
		return true;
	    }
	    iterator = iterator.getNext();
	}
	return false;
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
	Node iterator = first;
	int sizeCounter = 0;
	while (iterator != null) {
	    sizeCounter++;
	    System.out.println(iterator.getInfo());
	    iterator = iterator.getNext();
	}
	return sizeCounter;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int index(Node item) {
	if (first != null) {
	    int counter = 0;
	    Node<T> iterator = first;
	    while (iterator != null) {
		System.out.println("The value of list item is " + iterator.getInfo());
		if ((iterator.getInfo().compareTo((T) item.getInfo())) == 0) {
		    return counter;
		}
		counter++;
		iterator = iterator.getNext();
	    }
	}
	return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void append(Node item) {
	// INSERTS THE ITEM IN THE LIST POSITION OF THE LIST
	if (first == null) {
	    first = (Node<T>) item;
	    return;
	} else {
	    Node<T> iterator = first;
	    while (iterator.getNext() != null) {
		iterator = iterator.getNext();
	    }
	    iterator.setNext(item);
	}
    }

    @SuppressWarnings("unchecked")
    @Override
    public void insert(int position, Node item) {
	// INSERT THE ITEM IN THE SPECIFIED POSITION
	if (position == 0) {
	    Node<T> returningNode = first;
	    item.setNext(returningNode.getNext());
	    first = item;
	    return;
	} else {
	    if ((this.size() - 1) >= position) {
		Node<T> next = first;
		Node<T> previous = first;
		Node<T> current = first;
		while (position >= 0) {
		    previous = current;
		    current = next;
		    next = next.getNext();
		    position--;
		}
		previous.setNext(item);
		item.setNext(current);
	    } else {
		System.out.println("lack of elemnts present in the list insert at a lesser position again");
	    }
	}
    }

    @Override
    public Node<T> pop() {
	// REMOVES THE ELEMENTS FROM THE LAST
	if (first == null) {
	    System.out.println("No elements found list is empty");
	    return null;
	} else if (this.size() == 1) {
	    Node<T> returningNode = first;
	    Node<T> temp = first;
	    temp = temp.getNext();
	    first.setNext(null);
	    first = temp;
	    return returningNode;
	} else {
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
	if (position == 0) {
	    Node<T> returningNode = first;
	    Node<T> temp = first;
	    temp = temp.getNext();
	    first.setNext(null);
	    first = (Node<T>) temp;

	    return returningNode;
	} else {
	    if ((this.size() - 1) >= position) {
		Node<T> next = first;
		Node<T> previous = first;
		Node<T> current = first;
		while (position >= 0) {
		    previous = current;
		    current = next;
		    next = next.getNext();
		    position--;
		}
		previous.setNext(next);
		return current;
	    } else {
		System.out.println("lack of elemnts present in the list insert more and try again later");
	    }
	    return null;
	}

    }

}
