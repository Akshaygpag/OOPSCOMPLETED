package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.StackPureImpl;
import com.bridgelabz.algorithm.interfaces.Stack;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 25-May-2018
 */
public class QueueUsingStack<T extends Comparable<T>> {
    Stack<T> stack1, stack2;

    /**
     * ZERO ARGUMENT CONSTRUCTOR
     */
    public QueueUsingStack() {
	stack1 = new StackPureImpl<T>();
	stack2 = new StackPureImpl<T>();
    }

    /**
     * REMOVE THE ELEMENT FROM THE QUEUE
     * 
     * @return
     *
     */
    public Node<T> dequeue() {
	// STORES THE CONTENTS OF THE STACK TO ANOTHER STACK AND POP ELEMENT AND STORE
	// THE ELEMENT SBACK FROM SECOND STACK TO FIRST STACK
	stack2 = stack2.stack();
	while (!stack1.isEmpty()) {

	    Node<T> removedItem = stack1.pop();

	    stack2.push(removedItem);
	}

	Node<T> returningItem = stack2.pop();

	while (!stack2.isEmpty()) {
	  
	    Node<T> removedItem = stack2.pop();

	    stack1.push(removedItem);

	}
	return returningItem;
    }

    /**
     * PUSH THE ELEMENTS INTO THE QUEUE
     * 
     * @param item
     *
     */
    public void enqueue(Node<T> item) {
	// STORE THE ELEMENTS IN FILO ORDER
	stack1.push(item);
    }

    /**
     * SIZE OF THE QUEUE
     * 
     * @return
     * 
     */
    public int size() {
	// RETURNS THE NO CONTENTS OF THE STACK
	return stack1.size();

    }

    /**
     * CHECK FOR THE QUEUE IS EMPTY OR NOT
     * 
     * @return
     * 
     */
    public boolean isEmpty() {
	// IF STACK 1 IS EMPTY THEN THERE ARE NO ELEMENTS PRESENT IN THE QUEUE
	if (stack1.isEmpty()) {
	    return true;
	}
	return false;
    }

}
