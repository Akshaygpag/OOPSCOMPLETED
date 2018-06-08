package com.bridgelabz.datastructures.programs;

import com.bridgelabz.algorithm.impl.StackPureImpl;
import com.bridgelabz.algorithm.interfaces.Stack;
import com.bridgelabz.functionalprogramming.util.Utility;

public class StackMainMethod {

    public static void main(String[] args) {
	// THIS METHOD WILL TAKE THE USER INPUT STRING FOR THE EXPRESSION AND PUSH ( ,)
	// INTO THE STACK AND POP IF REQUIRED
	Stack<Character> myStack = new StackPureImpl<Character>();
	System.out.println("Enter a arithetic expression with paranthesis .");
	String expression = Utility.getUserStringValue();
	char[] expressionArray = expression.toCharArray();
	boolean result = isBracketsbalanced(expressionArray, myStack);
	System.out.println(" Is it balanced   : " + result + " ");

    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static boolean isBracketsbalanced(char[] expressionArray, Stack myStack) {
	// THIS METHOD WILL RETURN TRUE IT EXPRESSION IS BALANCED ELSE FALSE
	for (int i = 0; i < expressionArray.length; i++) {
	    if (expressionArray[i] == '(') {
		// THEN ONLY PERFORM THE PUSH OPERATIONS
		Node item = new Node();
		item.setInfo(String.valueOf(expressionArray[i]));
		myStack.push(item);
	    }
	    if (expressionArray[i] == ')') {
		// PERFORM THE POP OPERATIONS
		Node check = myStack.pop();
		if (check == null) {
		    return false;
		}
	    }
	}
	if (myStack.isEmpty()) {
	    return true;
	}
	return false;
    }
}
