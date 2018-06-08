
package com.bridgelabz.oops.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.bridgelabz.functionalprogramming.util.Utility;
import com.bridgelabz.oops.interfaces.StockType;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */
public class StockAccount implements StockType {

    private String fileName;
    private List<CompanyShares> myShares;

    private List<CompanyShares> allShares;

    public StockAccount(String name) {
	this();
	this.fileName = name;
    }

    /**
     * ZERO ARGUMENT CONSTRUCTOR
     */
    public StockAccount() {
	this.myShares = null;
    }

    public List<CompanyShares> getMyShares() {
	if (this.myShares == null) {
	    System.out.println("creating  my new list");

	    this.myShares = new ArrayList<CompanyShares>();
	}
	return myShares;
    }

    public List<CompanyShares> getAllShares() throws IOException, ParseException {
	if (allShares == null) {
	    File file = new File(fileName);
	    FileReader reader = new FileReader(file);
	    JSONParser parser = new JSONParser();
	    List<JSONObject> fileStockList = (List<JSONObject>) parser.parse(reader);
	    List<CompanyShares> allShare = new ArrayList<CompanyShares>();
	    AtomicInteger index = new AtomicInteger(1);
	    String[] data = new String[5];
	    data[0] = "ID";
	    data[1] = "STOCK NAME";
	    data[2] = "LAST TRANSACTION";
	    data[3] = "AVAILABLE";
	    data[4] = "STOCK PRICE";
	    System.out.println(String.format("%-2s  %-20s  %-40s  %-10s  %-10s", data));
	    for (JSONObject jsonObject : fileStockList) {
		CompanyShares stock = new CompanyShares();
		stock.setId(index.getAndIncrement());
		stock.setStockName(jsonObject.get("StockName").toString());
		stock.setStockPrice(Double.parseDouble(jsonObject.get("Price").toString()));
		stock.setNoOfStocks(Integer.parseInt(jsonObject.get("Available").toString()));
		System.out.println(stock);

		allShare.add(stock);

	    }

	    this.allShares = allShare;
	}
	return allShares;
    }

    public void setAllShares(List<CompanyShares> allShares) throws IOException, ParseException {

	this.allShares = allShares;
    }

    /*
     * PARAMETERIZED CONSTRUCTOR WITH FILE NAME
     * 
     * @param String name for file
     * 
     * @see com.bridgelabz.oops.interfaces.StockType#StockAccount(java.lang.String)
     */
    @Override
    public StockType StockAccount(String name) {
	// PARAMETERIZED CONSTRUCTOR WITH FILE NAME
	return new StockAccount(name);
    }

    /*
     * TOTAL VALUATION OF THE STOCKS PURCHASED
     * 
     * @see com.bridgelabz.oops.interfaces.StockType#valueOf()
     */
    @Override
    public double valueOf() {
	// TOTAL VALUATION OF THE STOCKS PURCHASED
	double valuation = 0.0;
	if (this.myShares.isEmpty()) {
	    return valuation;
	}
	Iterator findWorth = this.myShares.iterator();
	while (findWorth.hasNext()) {
	    CompanyShares stock = (CompanyShares) findWorth.next();
	    valuation += (stock.getStockPrice() * stock.getNoOfStocks());
	}
	return valuation;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.oops.interfaces.StockType#buy(int, java.lang.String)
     */
    @Override
    public void buy(int amount, String symbol) throws IOException, ParseException, CloneNotSupportedException {
	CompanyShares company = null;
	CompanyShares companyInMySystem = null;
	for (CompanyShares companyShares : this.getAllShares()) {
	    if (companyShares.getStockName().equalsIgnoreCase(symbol)) {
		company = companyShares;
		break;
	    }
	}
	if (company == null) {

	    System.out.println("Entered invalid name ......");
	    return;
	}
	if (company.getNoOfStocks() < amount) {
	    System.out.println("Enter a number lesser or equal to " + company.getNoOfStocks() + " to buy this stock");
	    amount = Utility.getIntergerValue();
	    if (amount <= 0) {
		return;
	    }
	    this.buy(amount, symbol);
	    return;

	}
	// ITS VALID AMOUNT
	for (CompanyShares companyShares : this.getMyShares()) {
	    if (companyShares.getStockName().equalsIgnoreCase(symbol)) {
		companyInMySystem = companyShares;
		break;
	    }
	}
	if (companyInMySystem == null) {
	    System.out.println("You  dont have these stocks ..");
	    companyInMySystem = new CompanyShares();
	    this.getMyShares().add(companyInMySystem);
	}
	company.setNoOfStocks(company.getNoOfStocks() - amount);
	companyInMySystem.setNoOfStocks(companyInMySystem.getNoOfStocks() + amount);
	companyInMySystem.setStockName(company.getStockName());
	companyInMySystem.setStockPrice(company.getStockPrice());
	companyInMySystem.setTransaction(new Date());

	System.out.println("Stocks left to buy");

	for (CompanyShares companyShares : allShares) {
	    System.out.println(companyShares);
	}

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.oops.interfaces.StockType#sell(int, java.lang.String)
     */
    @Override
    public void sell(int amount, String symbol) throws IOException, ParseException {
	// SELLS THE SHARE
	CompanyShares company = null;
	for (CompanyShares companyShares : this.getMyShares()) {
	    if (companyShares.getStockName().equalsIgnoreCase(symbol)) {
		company = companyShares;
		break;
	    }
	}
	if (company == null) {
	    System.out.println("You dont have the shares of " + symbol);
	    return;
	}
	if (company.getNoOfStocks() < amount) {
	    System.out.println("Stocks not available in this quantity (available = " + company.getNoOfStocks() + ")");
	    System.out.println("Do you want to enter a new quantity ?");
	    boolean value = Utility.getBooleanValue();
	    if (value) {
		System.out.println("Enter new quantity");
		this.sell(Utility.getIntergerValue(), symbol);
	    }
	    return;
	} else {

	    System.out.println("You have entered quantity = " + amount + "  !!!");
	    company.setNoOfStocks(company.getNoOfStocks() - amount);
	    company.setTransaction(new Date());

	    for (CompanyShares companyShares : this.getAllShares()) {
		if (companyShares.getStockName().equalsIgnoreCase(symbol)) {
		    company = companyShares;
		    break;
		}
	    }

	    company.setNoOfStocks(company.getNoOfStocks() + amount);
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.oops.interfaces.StockType#save(java.lang.String)
     */
    @Override
    public void save(String fileName) throws IOException {
	// SAVE THE ALLSHARES INTO THE FILE
	if (fileName == null) {
	    fileName = this.fileName;
	}

	File f = new File(fileName);

	if (f.exists()) {
	    f.delete();
	}
	f.createNewFile();

	FileWriter fileWriter = new FileWriter(f);

	BufferedWriter writer = new BufferedWriter(fileWriter);
	for (int i = 0; i < this.myShares.size(); i++) {
	    writer.write(this.myShares.get(i).toString());
	    writer.newLine();
	    writer.flush();

	}
	writer.close();
	fileWriter.close();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.bridgelabz.oops.interfaces.StockType#printReport()
     */
    @Override
    public void printReport() {
	// PRINTS THE FORMATTED REPORT
	AtomicInteger index = new AtomicInteger(1);
	for (int i = 0; i < this.getMyShares().size(); i++) {
	    this.getMyShares().get(i).setId(index.getAndIncrement());
	    System.out.println(this.getMyShares().get(i).toString());
	}

    }

    /* (non-Javadoc)
     * @see com.bridgelabz.oops.interfaces.StockType#printStack()
     */
    @Override
    public void printStack() {
	// bridgeit 
	
    }

    /* (non-Javadoc)
     * @see com.bridgelabz.oops.interfaces.StockType#printQueue()
     */
    @Override
    public void printQueue() {
	// bridgeit 
	
    }

}
