/**
 * @author Akshay
 * @version 1.0.0
 * @since 26-May-2018
 */

package com.bridgelabz.oops.classes;

/**
 * @author bridgeit
 *
 */
public class Stock {
    @Override
    public String toString() {
	return "Stock [stockName=" + stockName + ", noOfStocks=" + noOfStocks + ", sharePrice=" + sharePrice + "]";
    }

    private String stockName;
    private Integer noOfStocks;
    private Double sharePrice;

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

    public Double getSharePrice() {
	return sharePrice;
    }

    public void setSharePrice(Double sharePrice) {
	this.sharePrice = sharePrice;
    }

}
