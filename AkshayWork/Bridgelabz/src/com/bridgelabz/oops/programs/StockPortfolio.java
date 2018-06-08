
package com.bridgelabz.oops.programs;

import java.text.DecimalFormat;
import com.bridgelabz.functionalprogramming.util.Utility;
import com.bridgelabz.oops.classes.Stock;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */
public class StockPortfolio {

    /**
     * @param args
     * 
     */
    public static void main(String[] args) {

	System.out.println("Enter the number of stocks types");
	int items = Utility.getIntergerValue();
	Stock[] allStocks = getUserStockInputs(items);
	printStockReport(allStocks);

    }

    /**
     * @param allStocks
     * 
     */
    private static void printStockReport(Stock[] allStocks) {
	Double totalStockPrice = 0.0;
	Object[] stockDataHeaders = new Object[3];
	stockDataHeaders[0] = "Name";
	stockDataHeaders[1] = "Quantity";
	stockDataHeaders[2] = "Price";
	System.out.println(String.format("%-20s %-20s %20s", stockDataHeaders));
	System.out.println("-------------------------------------------------------------------");
	DecimalFormat decimalFormat = new DecimalFormat();
	for (int i = 0; i < allStocks.length; i++) {
	    Double stockPer = allStocks[i].getNoOfStocks() * allStocks[i].getSharePrice();
	    Object[] stockData = new Object[3];
	    totalStockPrice += stockPer;
	    stockData[0] = allStocks[i].getStockName();
	    stockData[1] = allStocks[i].getNoOfStocks().toString();
	    stockData[2] = stockPer.toString();
	    System.out.println(String.format("%-20s %-20s %20s " + decimalFormat.getCurrency(), stockData));
	}
	System.out.println("-------------------------------------------------------------------");
	stockDataHeaders[0] = "Total : ";
	stockDataHeaders[1] = totalStockPrice.toString();
	System.out.println(String.format("%-20s  %40s " + decimalFormat.getCurrency(), stockDataHeaders));

    }

    /**
     * @return
     * 
     */
    private static Stock[] getUserStockInputs(int items) {
	Stock[] allStocks = new Stock[items];
	for (int i = 0; i < items; i++) {
	    Stock stock = new Stock();
	    System.out.println("Enter stock name");
	    String stockName = Utility.getUserStringValue();
	    stock.setStockName(stockName);
	    System.out.println("Enter number of stock for " + stock.getStockName());
	    Integer totalStocks = Utility.getIntergerValue();
	    stock.setNoOfStocks(totalStocks);
	    System.out.println("Enter the price price for " + stock.getStockName());
	    Double pricePerStock = Utility.getDoubleValue();
	    stock.setSharePrice(pricePerStock);
	    allStocks[i] = stock;

	}

	return allStocks;
    }

}
