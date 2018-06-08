package com.bridgelabz.algorithms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.bridgelabz.algoritms.util.AlgorithmUtil;
import com.bridgelabz.functionalprogramming.util.Utility;
/**
 * FIND WORD FROM THE FILE 
 * @version 1.0.0
 * @author Akshay
 * @since 18-05-2018
 */
public class WordFinderFromList {
	private static final String FILE_PATH = "/home/bridgeit/fileHolder/wordList.txt";//GET FILE PATH
	public static void main(String[] args) {
		// THIS METHOD WILL READ IN THE WORDS FROM THE FILE AND TAKES THE USER INPUT FOR
		// THE SEARCH WORD

		File file = new File(FILE_PATH);
		FileReader read = null;
		if (!file.exists()) {
			System.out.println("File resource could not be found Error :404");
			return;

		}
		try {
			read = new FileReader(file);
			int c = -1;

			StringBuffer sb = new StringBuffer();
			try {
				while ((c = read.read()) != -1) {

					sb.append((char) c);

				}
				System.out.println(sb.toString());
				String[] data = sb.toString().split(",");

				System.out.println("User enter the country to be searched ");
				String key = Utility.getUserStringValue();

				String[] myData = AlgorithmUtil.bubbleSortArrays(data);

				int pos = AlgorithmUtil.binarySearch(myData, key);
				if (pos != -1) {
					System.out.println("Key = " + key + " was found in the file");

				} else {
					System.out.println("No match found for key = " + key);

				}

			} catch (IOException e) {
				//  EXCEPTION BLOCK ENTERS
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
