/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.oops.classes;

import com.bridgelabz.algorithm.interfaces.OrderedList;
import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.datastructures.programs.Node;
import com.bridgelabz.algorithm.impl.OrderedListImpl;
import com.bridgelabz.algorithm.impl.QueueImpl;

public class Player implements Comparable<Player> {
    final OrderedList cardsList = new OrderedListImpl();
    final Queue cardsOrder = new QueueImpl();

    public Queue getCardsOrder() {
	return cardsOrder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Player o) {
	// bridgeit
	return 0;
    }

    public OrderedList getCardsList() {
	return cardsList;
    }

    public <T> void addAll(T data) {
	OrderedList list = (OrderedList) data;

	while (!list.isEmpty()) {
	    Node card = list.pop(0);
	    this.cardsOrder.enqueue(card);
	}

    }

}
