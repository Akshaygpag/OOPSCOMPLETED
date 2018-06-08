package com.bridgelabz.datastructures.programs;

import java.util.List;
import com.bridgelabz.algorithm.impl.StackPureImpl;
import com.bridgelabz.algorithm.interfaces.Stack;
import com.bridgelabz.algorithms.PrimeAnagramsAndPalindrome;
import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * PRINTING THE ANAGRAMS IN REVERSE ORDER
 * 
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */
public class PrintAnagramInReverse {
    static final int UPPER_LIMIT = 1000;

    /**
     * METHOD WILL PERFORM CALLS TO PRIMENUMBERS AND PRIMEANAGRAMS METHODS
     * 
     * @param args
     * 
     */
    public static void main(String[] args) {
	Stack<Integer> anagramStack = new StackPureImpl<Integer>();
	Integer[] allPrimeNumbers = AlgorithmUtil.findPrimeNumbers(UPPER_LIMIT);// RETURNS INTEGER[] OF PRIME NUMBERS
										// BETWEEN 0 TO UPPER_LIMIT INCLUSIVE
	// FINDS THE
	// ANAGRAMS IN THE
	// GIVEN PRIME
	// NUMBER RANGE AND
	// RETURNS THE LIST
	// REFERENCE
	List<Integer> primeAnagrams = PrimeAnagramsAndPalindrome.findAnagramPrimes(allPrimeNumbers);
	for (Integer integer : primeAnagrams) {// ITERATING THROUGH ALL THE PRIME ANAGRAMS
	    Node<Integer> n = new Node<Integer>();// CREATE A NODE TO STORE INTEGER VALUES INSIDE THE NODE
	    n.setInfo(integer);
	    anagramStack.push(n);// PUSH THE NODE INTO THE STACK
	}
	// ALL ITEMS ARE PUSHED
	int seperator = 0;
	// PRINTING THE NUMBERS IN REVERSE ORDER
	while (!anagramStack.isEmpty()) {// TILL THE STACK IS EMPTY POP
	    StringBuffer reversingString = new StringBuffer(anagramStack.pop().getInfo().toString());// POP THE ELEMENTS
	    if (seperator != 0 && seperator % 2 != 0) {// IF THE NUMBERS ARE IN PAIR THEN SEPERATE THEM USING ","
		System.out.print(reversingString + "\n");
		seperator++;
		continue;
	    }
	    System.out.print(reversingString + " , ");// SPACE BETWEEN THE PAIR
	    seperator++;

	}
    }
}
