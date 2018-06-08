/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.oops.programs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DeckOfCards {
    String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
    String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
    Set<String> readyCards = new HashSet<String>();

    public static void main(String[] args) {
	DeckOfCards deckOfCards = new DeckOfCards();

	deckOfCards.generateCard();

	System.out.println("Cards are ready to be generated");
	String[][] game = new String[4][9];

	Iterator<String> iterator = deckOfCards.readyCards.iterator();
	int start = 0;
	int index = 0;

	while (iterator.hasNext()) {
	    if ((index) % 9 == 0 && index != 0) {
		index = 0;
		start++;
	    }
	    game[start][index++] = iterator.next().toString();
	}
	for (int i = 0; i < game.length; i++) {
	    for (int j = 0; j < game[i].length; j++) {
		System.out.print(String.format("%-20s", game[i][j]));
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
