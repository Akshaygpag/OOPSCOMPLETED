/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;


public interface Queue<T extends Comparable<T>> {
    Queue<T> Queue();

    void enqueue(Node<T> customer);

    Node<T> dequeue();

    boolean isEmpty();

    int size();
    
    
    Node<T> peek();

}
