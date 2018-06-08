
package com.bridgelabz.datastructures.programs;

import java.util.List;

import com.bridgelabz.algorithm.impl.QueueImpl;
import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.algorithms.PrimeAnagramsAndPalindrome;
import com.bridgelabz.algoritms.util.AlgorithmUtil;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */
public class PrimeAnagramPrintUsingQueue {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {
	// THIS METHOD WILL CALL THE PRIMEANAGRAMS TO BE ADDED TO QUEUE AND POP AND
	// PRINT THEM

	Queue<Integer> primeQueue = new QueueImpl<Integer>();
	Integer[] allPrimeNumbers = AlgorithmUtil.findPrimeNumbers(1000);
	List<Integer> primeAnagrams = PrimeAnagramsAndPalindrome.findAnagramPrimes(allPrimeNumbers);
	for (Integer integer : primeAnagrams) {
	    Node<Integer> n = new Node<Integer>();
	    n.setInfo(integer);
	    primeQueue.enqueue(n);
	}
	int seperator = 0;
	while (!primeQueue.isEmpty()) {
	    StringBuffer reversingString = new StringBuffer(primeQueue.dequeue().getInfo().toString());// POP THE
												       // ELEMENTS
	    if ((seperator) % 2 != 0 && seperator != 0) {// IF THE NUMBERS ARE IN PAIR THEN SEPERATE THEM USING ","
		System.out.print(reversingString + "\n");// SPACE BETWEEN THE PAIR
		seperator++;
		continue;
	    }
	    System.out.print(reversingString + ",");// SPACE BETWEEN THE PAIR
	    seperator++;
	}
    }
}
