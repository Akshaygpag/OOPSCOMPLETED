/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.oops.classes;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class CompanyShares implements Comparable<CompanyShares>,Cloneable {
    private Integer id = new Integer(0);
    private String stockName;
    private Integer noOfStocks = new Integer(0);
    private Double stockPrice = new Double(0.0D);

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    private Date transaction;

    public Double getStockPrice() {
	return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
	this.stockPrice = stockPrice;
    }

    @Override
    public String toString() {

	String[] data = new String[5];
	data[0] = String.valueOf(this.id);
	data[1] = this.stockName;
	data[2] = this.getTransaction().toString();
	data[3] = String.valueOf(this.noOfStocks);
	data[4] = String.valueOf(this.stockPrice);
	return String.format("%-2s  %-20s  %-40s  %-10s  %-30s", data);

    }

    public String getStockName() {
	return stockName;
    }

    public void setStockName(String stockName) {
	this.stockName = stockName;
    }

    public Integer getNoOfStocks() {
	return noOfStocks;
    }

    public void setNoOfStocks(Integer noOfStocks) {
	this.noOfStocks = noOfStocks;
    }

    public Date getTransaction() {
	if (transaction == null) {

	    return new Date();

	}
	return this.transaction;

    }

    public void setTransaction(Date transaction) {
	this.transaction = transaction;
    }

    public Object clone() throws CloneNotSupportedException {
	return super.clone();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(CompanyShares o) {

	if (this.getStockName().compareTo(o.getStockName()) < 1) {
	    return -1;

	} else if (this.getStockName().compareTo(o.getStockName()) > 1) {
	    return 1;
	} else {
	    return 0;
	}

    }
}
