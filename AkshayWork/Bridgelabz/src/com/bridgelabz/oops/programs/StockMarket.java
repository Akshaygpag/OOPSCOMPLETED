/**
 * @author Akshay
 * @version 1.0.0
 * @since 29-May-2018
 */

package com.bridgelabz.oops.programs;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgelabz.functionalprogramming.util.Utility;
import com.bridgelabz.oops.classes.StockAccount;
import com.bridgelabz.oops.interfaces.StockType;

/**
 * @author bridgeit
 *
 */
public class StockMarket {

    /**
     * @param args
     * @throws ParseException
     * @throws IOException
     * @throws CloneNotSupportedException
     * 
     */
    public static void main(String[] args) throws IOException, ParseException, CloneNotSupportedException {
	System.out.println("System starting...");
	StockType account = new StockAccount("/home/bridgeit/fileHolder/shares.json");
	boolean stop = false;
	while (!stop) {

	    System.out.println("\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "\u04FE" + "" + "\u04FE" + ""
		    + "\u04FE" + "" + "\u04FE" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "\u04FE"
		    + "" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE");
	    System.out.println("Enter your choice.............");
	    System.out.println("1.Buy shares");
	    System.out.println("2.Sell shares");
	    System.out.println("3.Print Report");
	    System.out.println("4.Total Value  ");
	    System.out.println("5.Save to file");
	    System.out.println("6.Exit");
	    System.out.println("\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "\u04FE" + "" + "\u04FE" + ""
		    + "\u04FE" + "" + "\u04FE" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE" + "\u04FE"
		    + "" + "\u04FE" + "" + "\u04FE" + "" + "\u04FE");

	    int operation = Utility.getIntergerValue();
	    if (operation == 6) {
		System.exit(1);
	    }
	    String symbol = null;
	    int amount = 0;
	    switch (operation) {

	    case 1:
		System.out.println("Enter the company symbol whose stocks you want to buy ..");

		symbol = Utility.getUserStringValue();
		System.out.println("Enter the number of shares to buy..");
		amount = Utility.getIntergerValue();
		account.buy(amount, symbol);
		break;
	    case 2:
		System.out.println("Enter the company symbol whose stocks you want to sell..");
		symbol = Utility.getUserStringValue();
		System.out.println("Enter the number of shares to sell..");
		amount = Utility.getIntergerValue();
		account.sell(amount, symbol);
		break;
	    case 3:
		System.out.println("Printing the report.......");
		account.printReport();
		break;
	    case 4:
		System.out.println("Total expenditure in buying the stocks are..." + account.valueOf());
		break;
	    case 5:
		System.out.println("Enter the file name to be stored as along with the path ");

		String fileName = Utility.getUserStringValue();

		System.out.println("Saving the report to a file ");

		account.save(fileName);
		break;
	    default:
		System.out.println("Invalid input provided please try again ....!");

	    }

	}

    }

}
