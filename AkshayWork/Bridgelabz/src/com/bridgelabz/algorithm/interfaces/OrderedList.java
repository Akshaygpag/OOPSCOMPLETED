package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.datastructures.programs.Node;

public interface OrderedList<T extends Comparable<T>> extends Cloneable {

    OrderedList<T> list();

    void add(Node<T> item);

    void remove(Node<T> item);

    boolean search(Node<T> item);

    boolean isEmpty();

    int size();

    int index(Node<T> item);

    Node<T> pop();

    Node<T> pop(int position);

    void printElements();

     Object clone() throws CloneNotSupportedException;
     public Node<T> get(int position);
}
