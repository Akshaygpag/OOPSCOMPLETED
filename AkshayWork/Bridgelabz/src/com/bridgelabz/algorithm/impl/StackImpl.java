package com.bridgelabz.algorithm.impl;

import com.bridgelabz.algorithm.interfaces.Stack;
import com.bridgelabz.datastructures.programs.Node;

public class StackImpl implements Stack {

    Node first, top;

    public StackImpl() {}

    @Override
    public Stack stack() {
	// CREATES A NEW STACK
	return new StackImpl();
    }

    @Override
    public void push(Node item) {
	// TAKES THE ITEM AND PUSHED IT INTO THE STACK IN FILO ORDER

	if (first == null) {

	    first = item;
	    top = item;
	    System.out.println("Pushed into stack");
	    System.out.println(this.size() + " stack size");
	    return;
	}

	top.setNext(item);

	top = item;
	System.out.println("Pushed into stack");
	System.out.println(this.size() + " stack size");

    }

    @Override
    public Node pop() {
	// POP THE ELEMENT FROM THE TOP

	if (top == null) {
	    System.out.println("Stack is empty");
	    return null;
	}
if(top==first) {
    
    Node contains=top;
    top=null;
    first=null;
    return contains;
}
	Node current = first;
	Node previous = first;
	while (current != top) {
	    previous = current;
	    current = current.getNext();
	}
	previous.setNext(null);
	top = previous;
	System.out.println("After poopping the size is : " + this.size());
	return current;

    }

    @Override
    public Node peek() {
	// SEES THE NEXT TOP MOST ELEMENT FROM THE STACK

	if (top != null) {

	    System.out.println("Stack is empty");
	    return top;
	}
	System.out.println("Empty stack");
	return null;

    }

    @Override
    public boolean isEmpty() {
	// ISEMPTY THIS METHOD WILL CHECK IF THE STACK IS EMPTY OR NOT AND GIVE
	// RESPECTIVE BOOLEAN VALUE
	if (top == null || first == null) {

	    return true;

	}
	return false;

    }

    @Override
    public int size() {
	// THIS METHOD WILL RETURN THE SIZE OF THE STACK
	int size = 0;
	Node current = first;
	while (current != null) {

	    size++;
	    current = current.getNext();

	}

	return size;

    }

}
