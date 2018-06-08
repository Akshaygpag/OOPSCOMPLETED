package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;

public interface Stack<T extends Comparable<T>> {
    Stack<T> stack();

    void push(Node<T> item);

    Node<T> pop();

    Node<T> peek();

    boolean isEmpty();

    int size();
}
