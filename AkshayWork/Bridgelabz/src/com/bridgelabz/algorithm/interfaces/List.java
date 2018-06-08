package com.bridgelabz.algorithm.interfaces;

import com.bridgelabz.algorithm.impl.UnOrderedList;
import com.bridgelabz.datastructures.programs.Node;

public interface List<T extends Comparable<T>> {
    UnOrderedList list();
    void add(Node<T> item);

    Node<T> remove(Node<T> item);

    boolean search(Node<T> item);

    boolean isEmpty();

    int size();

    void append(Node<T> item);

    int index(Node<T> item);

    void insert(int position, Node<T> item);

    Node<T> pop();

    Node<T> pop(int position);
}
