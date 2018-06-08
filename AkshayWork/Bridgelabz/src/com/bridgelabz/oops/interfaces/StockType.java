/**
 * @author Akshay
 * @version 1.0.0
 * @since 28-May-2018
 */

package com.bridgelabz.oops.interfaces;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface StockType {

    StockType StockAccount(String name);

    double valueOf();

    void buy(int amount, String symbol) throws IOException, ParseException, CloneNotSupportedException;

    void sell(int amount, String symbol) throws IOException, ParseException, CloneNotSupportedException;

    void save(String fileName) throws IOException;

    void printReport();

    void printStack();

    void printQueue();
}
