package com.bridgelabz.oops.programs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import com.bridgelabz.algorithm.impl.QueueImpl;
import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.datastructures.programs.Node;
import com.bridgelabz.oops.classes.Player;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */
public class PrintDeckCardsUsingQueue {
    String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    Set<String> readyCards = new HashSet<String>();

    public static void main(String[] args) {
	Queue<Player> playeQueue = new QueueImpl<Player>();
	PrintDeckCardsUsingQueue deckOfCards = new PrintDeckCardsUsingQueue();
	deckOfCards.generateCard();
	System.out.println("Cards are ready to be generated");
	Iterator<?> iterator = deckOfCards.readyCards.iterator();
	int index = 0;
	Player player = new Player();
	while (iterator.hasNext()) {
	    if ((index) % 9 == 0 && index != 0) {
		Node<Player> node = new Node<Player>();
		player.addAll(player.getCardsList());
		node.setInfo(player);
		playeQueue.enqueue(node);
		player = new Player();

		index = 0;
	    }
	    Node<String> card = new Node<String>();
	    index++;
	    card.setInfo(iterator.next().toString());

	    player.getCardsList().add(card);
	}
	Node<Player> node = new Node<Player>();
	player.addAll(player.getCardsList());
	node.setInfo(player);
	playeQueue.enqueue(node);

	while (!playeQueue.isEmpty()) {
	    Node<?> singlePlayer = playeQueue.dequeue();
	    Player p1 = (Player) singlePlayer.getInfo();
	    while (!p1.getCardsOrder().isEmpty()) {
		System.out.print(String.format("%-20s", p1.getCardsOrder().dequeue().getInfo()));
	    }
	    System.out.println();
	}
    }

    private void generateCard() {
	while (readyCards.size() != 36) {
	    String card = getRandomSuit().concat(" " + getRandomRank());
	    readyCards.add(card);
	}
    }

    private String getRandomRank() {
	Random rand = new Random();
	int index = rand.nextInt(13);
	return rank[index];
    }

    private String getRandomSuit() {
	Random rand = new Random();
	int index = rand.nextInt(4);
	return suit[index];

    }

}
