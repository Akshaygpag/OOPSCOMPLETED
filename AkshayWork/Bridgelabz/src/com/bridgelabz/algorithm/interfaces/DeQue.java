/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */

package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;

/**
 * @author bridgeit
 *
 */
public interface DeQue<T extends Comparable<T>> {

    DeQue<T> Deque();

    void addFront(Node<T> item);

    void addRear(Node<T> item);

    Node<T> removeFront();

    Node<T> removeRear();

    boolean isEmpty();

    int size();

    Node<T> getFront();

    Node<T> getRear();

}
