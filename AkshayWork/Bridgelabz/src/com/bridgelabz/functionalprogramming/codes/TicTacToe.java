package com.bridgelabz.functionalprogramming.codes;

import java.util.HashMap;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @since 17-05-2018
 * @version 1.0.0
 */
class Position {
	int row;
	int col;

	public Position() {

		Random random = new Random();
		this.row = random.nextInt(3);
		this.col = random.nextInt(3);

	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

}

public class TicTacToe {
	final String NAME;
	char[][] ticGame = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } };
	static boolean endGame;
	static boolean playerWins;
	final static Map<Integer,String> map;
	
static {
	
map=new HashMap<Integer,String>(); 
	
	map.put(1, "0,0");
	map.put(2, "0,1");

	map.put(3, "0,2");

	map.put(4, "1,0");

	map.put(5, "1,1");

	map.put(6, "1,2");

	map.put(7, "2,0");

	map.put(8, "2,1");
	map.put(9, "2,2");

	
	
}	

public TicTacToe(String name) {
		// CONTRUCTOR FOR THE GAME
		NAME = name;
	}

	private void playerPlays(TicTacToe game) {
		// PLAYER CHANCE TO PLAY
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose position ");
		int x = Integer.parseInt(scan.nextLine());

String pos=		TicTacToe.map.get(Integer.valueOf(x));
	
String[] indexs=pos.split(",");
// System.out.println("checking with user value then will come to k now");


boolean endGame = game.isValidMove(Integer.valueOf(indexs[0]), Integer.valueOf(indexs[1]), game, 'X');
		// System.out.println("is the game finished " + !endGame);
		if (endGame) {
		} else {
			System.out.println("game ends.....");
		}
		Utility.printTicTacToe(game.ticGame);
		System.out.println("Computer turn ...");
	}

	private void computerPlays(TicTacToe game) {
		try {

			// COMPUTER CHANCE TO PLAY
			Position position = new Position();
			boolean endGame = game.isValidMove(position.getRow(), position.getCol(), game, 'O');

			if (endGame) {

			} else {
				System.out.println("game ends... in computer side..");
			}
			Utility.printTicTacToe(game.ticGame);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean isValidMove(int row, int col, TicTacToe game, char symbol) {
		// CHECK IF THERE IS ANY PLACE TO BE PLACING THE SYMBOL

		endGame = checkIfEmpty(game);

		if (endGame) {
			if (ticGame[row][col] != 'X' && ticGame[row][col] != 'O') {
				ticGame[row][col] = symbol;
				// System.out.println("selected the thing ");
				return true;

			} else {
				// System.out.println("generating a new rnadom variable");
				Position pos = new Position();

				return isValidMove(pos.getRow(), pos.getCol(), game, symbol);

			}

		} else {
			return false;
		}

	}

	private boolean checkIfEmpty(TicTacToe game) {
		// CHECK IF THERE IS ANY EMPTY BOX
		// System.out.println("The length from wheere to wwher ether itertation will
		// happen" + game.ticGame.length);
		for (int i = 0; i < game.ticGame.length; i++) {
			for (int j = 0; j < game.ticGame[i].length; j++) {
				if (game.ticGame[i][j] == '_') {
					System.out.println("The game can be played here please continue");
					return true;
				}
			}
		}
		// System.out.println("couldnot find any empty space in here on the board");
		return false;
	}

	public static void main(String[] args) {

		// MAIN METHOD TAKES THE USER NAME AND STARTS THE GAME

		System.out.println("Welcome player name ?");
		Scanner scan = new Scanner(System.in);
		TicTacToe game = new TicTacToe(scan.nextLine());
		System.out.println("Computer is player 1 .");
		System.out.println("You are player 2 .");
		endGame = true;
		while (endGame) {
			boolean value;
			game.computerPlays(game);
			value = isThereAWinner('O', game);
			if (value) {
				break;
			}

			if (game.checkIfEmpty(game)) {

				System.out.println(" your turn " + game.NAME);
				game.playerPlays(game);
				playerWins = isThereAWinner('X', game);
				value = playerWins;
				if (value) {
					break;
				}

			} else {
				System.out.println("its a draw");

			}

		}

		if (playerWins) {

			System.out.println("Bravo ");

		} else {
			System.out.println("game over");
		}

	}

	private static boolean isThereAWinner(char symbol, TicTacToe game) {
		// CHECKS FOR THE RESULT OF CONQUER TRUE MEANS THERE IS A WINNER AND FALSE MEANS
		// STILL NO WINNER

		/*
		 * System.out.println("The horizonatal check  result is : " +
		 * checkHorizontally(symbol, game));
		 * 
		 * System.out.println("The vertical va;lue resyult is " +
		 * checkVertically(symbol, game));
		 * 
		 * System.out.println("The vertical va;lue resyult is " +
		 * checkDiagonally(symbol, game)); System.out.println( checkHorizontally(symbol,
		 * game) || checkVertically(symbol, game) || checkDiagonally(symbol, game));
		 */
		return checkHorizontally(symbol, game) || checkVertically(symbol, game) || checkDiagonally(symbol, game);

	}

	private static boolean checkDiagonally(char symbol, TicTacToe game) {
		// CHECK IT THE CONQUER IS DIAGONALLY
		if (game.ticGame[1][1] != symbol) {
			return false;
		}
		// WILL CHECK FOR LEFT DIAGONAL AND RIGHT DIAGONAL
		return game.leftDaigonal(symbol, game) || game.rightDiagonal(symbol, game);

	}

	private boolean rightDiagonal(char symbol, TicTacToe game) {

		for (int i = 0; i < game.ticGame.length; i++) {

			for (int j = 0; j < game.ticGame[i].length; j++) {
				if (j + i == 2) {
					if (!(game.ticGame[i][j] == symbol)) {
						return false;
					}

				}

			}

		}
		return true;
	}

	private boolean leftDaigonal(char symbol, TicTacToe game) {
		for (int i = 0; i < game.ticGame.length; i++) {

			for (int j = 0; j < game.ticGame[i].length; j++) {
				if (j == i) {
					if (!(game.ticGame[i][j] == symbol)) {
						return false;
					}

				}

			}

		}

		return true;
	}

	private static boolean checkVertically(char symbol, TicTacToe game) {
		boolean verticalFlag = false;

		for (int i = 0; i < game.ticGame.length; i++) {

			for (int j = 0; j < game.ticGame[i].length; j++) {
				if (!(game.ticGame[j][i] == symbol)) {
					verticalFlag = false;
					break;
				} else {
					verticalFlag = true;

				}

			}
		}
		return verticalFlag;

	}

	private static boolean checkHorizontally(char symbol, TicTacToe game) {
		boolean horizontalFlag = false;
		for (int i = 0; i < game.ticGame.length; i++) {

			for (int j = 0; j < game.ticGame[i].length; j++) {
				if (!(game.ticGame[i][j] == symbol)) {
					horizontalFlag = false;
					break;
				} else {
					horizontalFlag = true;

				}
			}
		}

		return horizontalFlag;
	}

}
