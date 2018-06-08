package com.bridgelabz.functionalprogramming.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.datastructures.programs.Node;

public class Utility {
    static int counter = 0;
    static char[] value;
    static Scanner scanner = new Scanner(System.in);
    static List<String> combinations = new ArrayList<String>();

    public static List<String> getCombinations() {
	return combinations;
    }

    public static final void setString(String data) {
	value = data.toCharArray();

    }

    public static int callRecurssive(int current, int end) {
	recurssivePermutation(current, end);
	System.out.println("The value of arrangements inrecurssive is " + counter);
	return counter;
    }

    // ARRAY.LENGTH-1 IS TIMES
    public static final void recurssivePermutation(int current, int end) {

	if (current == end) {
	    counter++;
	    combinations.add(new String(value));
	    return;
	}
	int ref = current;
	while (ref <= end) {

	    swap(value, ref, current);

	    recurssivePermutation(current + 1, end);

	    swap(value, ref, current);
	    ref++;
	}

    }

    private static String printArray(char[] value) {
	// RETURN THE ARRAY
	return new String(value);
    }

    public static final char[] swap(char[] array, int a, int b) {
	char temp = array[a];
	array[a] = array[b];
	array[b] = temp;
	return array;

    }

    public static int iterativePermutation(int curr, int end) {
	List<StringBuffer> containsPermutes = new ArrayList<>();
	StringBuffer sb = new StringBuffer();
	List<StringBuffer> containsCopy = new ArrayList<>();
	for (int i = end; i >= 0; i--) {
	    // TO GET ELEMENTS TO BE INSERTED INTO THE ARRAYLIST TO CALCULATE NTH PERMU FROM
	    // N-1 PERMU

	    String element = String.valueOf(value[i]);// get element
	    // IF THE ELEMENT IS THE FIRST SELECTED ELEMENT
	    if (sb.length() == 0) {
		sb.append(element);
		containsPermutes.add(new StringBuffer(element));
	    } else {
		// IF THE IS NEED FOR PERMUTATION OF N FROM N-1
		for (int j = 0; j < containsPermutes.size(); j++) {
		    int lastPos = containsPermutes.get(j).length();
		    int startPos = 0;

		    // FETCH EACH INDEX AND TRY TO PLACE THE VALUE AT THAT INDEX FOR EACH N-1
		    // PERMUTATION AVAILABLE
		    while (startPos <= lastPos) {
			String data = containsPermutes.get(j).toString();
			StringBuffer strCopy = new StringBuffer(data);
			strCopy.insert(startPos, element);
			containsCopy.add(strCopy);
			startPos++;
			strCopy = null;

		    }

		}
		// COPY TO BE REPLACED BY ORIGINAL AND CLEAR OUT THE WASTE MEMORY
		containsPermutes.clear();
		containsPermutes.addAll(containsCopy);
		containsCopy.clear();

	    }

	}
	// RESULT
	System.out.println(containsPermutes.size() + "  : is the no of arragements generated in iterative method");
	return containsPermutes.size();
    }

    public static final int getRandomInt() {

	Random rand = new Random();
	return rand.nextInt(100) % 10;

    }

    public static final Object[][] setArrayData(int row, int col) {

	Object arrayData[][] = getArrayData(row, col);

	return arrayData;

    }

    private static Object[][] getArrayData(int row, int col) {
	// LETS USER SELECT THE TYPE OF DATA TO BE INPUTED

	System.out.println("Select the type of array to be created 1.Integer 2.Double 3.Boolean ");

	String value = scanner.nextLine();
	switch (value) {
	case "1":
	    return integerDataSet(row, col);
	case "2":
	    return doubleDataSet(row, col);
	case "3":
	    return booleanDataSet(row, col);
	default:
	    System.out.println("Invalid choice selected");

	}

	// TAKES IN INPUT VALUES OF THE DATA THAT IS TO BE SET
	return null;
    }

    private static Object[][] booleanDataSet(int row, int col) {
	// TAKES THE USER VALUES FOR THE BOOLEAN
	System.out.println("you have selected the boolean data type");
	Boolean[][] arrayData = new Boolean[row][col];

	for (int i = 0; i < row; i++) {

	    for (int j = 0; j < col; j++) {

		System.out.println("Enter the data at [" + i + "]" + "[" + j + "]");
		arrayData[i][j] = Boolean.valueOf(scanner.nextBoolean());

	    }

	}
	return arrayData;
    }

    private static Object[][] doubleDataSet(int row, int col) {
	// TAKES ALL THE CODES FOR THE DOUBLE
	Double[][] arrayData = new Double[row][col];

	for (int i = 0; i < row; i++) {

	    for (int j = 0; j < col; j++) {

		System.out.println("Enter the data at [" + i + "]" + "[" + j + "]");
		try {

		    arrayData[i][j] = Double.valueOf(scanner.nextDouble());
		} catch (Exception e) {

		    System.out.println("exception at the message is " + e.getMessage());
		    e.printStackTrace();

		}
	    }

	}
	return arrayData;
    }

    private static Object[][] integerDataSet(int row, int col) {
	// TAKES ALL THE CODES FOR INTEGER
	Integer[][] arrayData = new Integer[row][col];

	for (int i = 0; i < row; i++) {

	    for (int j = 0; j < col; j++) {

		System.out.println("Enter the data at [" + i + "]" + "[" + j + "]");
		arrayData[i][j] = scanner.nextInt();

	    }

	}
	return arrayData;

    }

    public static final int[] setSingleIntArrayData(int len) {
	int array[] = new int[len];
	for (int i = 0; i < array.length; i++) {
	    System.out.println("Enter data at " + i + " position");
	    array[i] = scanner.nextInt();

	}
	return array;

    }

    public static void printTicTacToe(char game[][]) {
	// GENERATES VISUAL TO THE PLAYER
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < game.length; i++) {
	    for (int j = 0; j < game[i].length; j++) {

		sb.append("\t" + game[i][j] + "");

	    }
	    sb.append("\n");

	}
	System.out.println(sb.toString());

    }

    public static int getIntergerValue() {

	int data = scanner.nextInt();
	scanner.nextLine();
	return data;
    }

    public static String getUserStringValue() {
	return scanner.nextLine();

    }

    public static int[] getArrayDataInt() {
	// GET THE USER INPUTS FOR THE ONE DIMENTIONAL ARRAY OF INT VALUES

	System.out.println("Enter the size of array of data ");

	int size = getIntergerValue();

	if (size < 1) {
	    return null;
	}
	int[] dataList = new int[size];
	for (int i = 0; i < size; i++) {
	    System.out.println("Enter the value to be put in the position [" + i + "]");
	    dataList[i] = getIntergerValue();

	}

	return dataList;
    }

    public static String[] getArrayDataString() {
	// GET THE USER INPUTS FOR THE ONE DIMENTIONAL ARRAY OF STRING VALUES

	System.out.println("Enter the size of array of data ");

	int size = getIntergerValue();

	if (size < 1) {
	    return null;
	}
	String[] dataList = new String[size];
	for (int i = 0; i < size; i++) {
	    System.out.println("Enter the value to be put in the position [" + i + "]");
	    dataList[i] = getUserStringValue();

	}

	return dataList;

    }

    public static <T> void printArray(T[] data) {
	for (T i : data) {

	    System.out.print(i + " ");
	}
	System.out.println();
	return;

    }

    public static void printIntArray(int[] data) {
	for (int i : data) {

	    System.out.print(i + " ");
	}
	System.out.println();
	return;

    }

    public static void printStringArray(String[] sortedStringData) {
	for (String i : sortedStringData) {

	    System.out.print(i + " ");
	}
	System.out.println();
	return;

    }

    public static boolean getBooleanValue() {

	boolean result = scanner.nextBoolean();
	scanner.nextLine();

	return result;

    }

    public static double getDoubleValue() {

	double result = scanner.nextDouble();
	scanner.nextLine();

	return result;

    }

    public static long getLongValue() {
	long changeRequested = scanner.nextLong();
	scanner.nextLine();
	return changeRequested;
    }

    public static Node<Integer> getNodeValue() {
	// SETS THE INFO FOR THE NODE BY TAKING USER INPUTS

	int info = scanner.nextInt();
	Node<Integer> node = new Node<Integer>();

	Integer i = info;
	node.setInfo(i);
	return node;
    }

    public static int stringToInteger(String data) {
	return Integer.parseInt(data.trim());

    }

    public static Integer[] convertIntToIntArray(Integer intergerValue) {
	// CONVERTS INT TO INT []
	int size = String.valueOf(intergerValue).length();
	Integer[] array = new Integer[size];
	int remainder = -1;
	int lastIndex = size - 1;
	int unSignedIntValue = Math.abs(intergerValue);

	while (lastIndex >= 0) {
	    remainder = unSignedIntValue % 10;
	    array[lastIndex--] = remainder;
	    unSignedIntValue /= 10;
	}

	return array;
    }

    public static <T extends Comparable<T>> T[] sortDescendingOrder(T[] value) {

	for (int i = 0; i < value.length - 1; i++) {// NO OF ITERATIONS REQUIRED FOR SORTING

	    for (int j = 0; j < value.length - i - 1; j++) {// COMPARE WITH THE NEXT ELEMENT IF GREATER THEN SWAP ELSE
							    // CONTINUE

		if (value[j].compareTo(value[j + 1]) < 0) {
		    AlgorithmUtil.swap(j + 1, j, value);// CALL TO SWAP METHOD

		}

	    }

	}
	return value;
    }

    public static final void recurssivePermutationForNibble(int current, int end) {

	if (current == end) {
	    counter++;

	    System.out.println("hello");
	    //
	    // System.out.println(new String(value));
	    // combinations.add(new String(value));
	    return;
	}
	int ref = current;
	while (ref <= end) {

	    swap(value, ref, current);

	    recurssivePermutation(current + 1, end);

	    swap(value, ref, current);
	    ref++;
	}

    }

}
