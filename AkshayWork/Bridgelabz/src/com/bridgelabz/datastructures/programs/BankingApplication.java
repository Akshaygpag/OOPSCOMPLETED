package com.bridgelabz.datastructures.programs;


import com.bridgelabz.algorithm.impl.QueueImpl;

import com.bridgelabz.algorithm.interfaces.Queue;
import com.bridgelabz.commons.Customer;
import com.bridgelabz.functionalprogramming.util.Utility;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 23-May-2018
 */
public class BankingApplication {

    /**
     * @param args
     * 
     */
    private long balanceAmount;// GIVES THE BALANCEAMOUNT

    /**
     * PARAMETERIZED CONSTRUCTOR
     * 
     * @param balanceAmount
     */
    public BankingApplication(long balanceAmount) {
	this.balanceAmount = balanceAmount;
    }

    public static void main(String[] args) {
	// THIS METHOD WILL START THE QUEUE AND THEN ADD AND REMOVE PEOPLE
	// IT WILL HAVE AN INITAL BALANCE

	System.out.println("Enter the initial amount of money the cashier must hold ");
	long money = Utility.getLongValue();
	BankingApplication bankCounter = new BankingApplication(money);
	bankCounter.open();

    }

    /**
     * OPENS THE BANK CASH COUNTER
     */
    private void open() {
	// THIS METHOD WILL START THR BANK COUNTER
	Queue<Customer> bankCustomersQueue = new QueueImpl<Customer>();
	Queue<Customer> largeWithdrawCustomers = new QueueImpl<Customer>();

	boolean stop = false;
	while (!stop) {
	    System.out.println();
	    System.out.println("---------------------");
	    System.out.println("Current balance is : " + this.balanceAmount);

	    System.out.println("---------------------");

	    System.out.println();

	    System.out.println("Enter 1.Add customer");
	    System.out.println("Enter 2.Remove customer");

	    System.out.println("Enter 3 to exit and close the counter");
	    int choice = Utility.getIntergerValue();

	    if (choice == 3) {
		stop = true;
	    }
	    if (choice == 2) {
		// REMOVE THE CUSTOMER FROM THE QUEUE
		if (largeWithdrawCustomers.isEmpty()) {
		    if (bankCustomersQueue.isEmpty()) {
			System.out.println("empty queue");
		    } else {
			this.requestHandler(largeWithdrawCustomers, bankCustomersQueue);
		    }
		} else {
		    // IF LARGEWITHDRAW IS NOT EMPTY THE CHECK
		    this.handlelargeTransactionCustomers(largeWithdrawCustomers, bankCustomersQueue);
		}
	    }
	    if (choice == 1) {
		this.addCustomers(bankCustomersQueue);
	    }
	}
	System.out.println("The end of the day balance at the counter is : " + this.balanceAmount);
    }

    /**
     * CHECKS FOR THE PEOPLE WHO ARE WAITING INSIDE THE LARGE TRANSACTION QUEUE AND
     * HANDLES THEIR REQUEST
     * 
     * @param largeWithdrawCustomers
     * @param bankCustomersQueue
     * 
     */
    private void handlelargeTransactionCustomers(Queue<Customer> largeWithdrawCustomers, Queue<Customer> bankCustomersQueue) {
	Node<Customer> waitingCustomer = largeWithdrawCustomers.peek();
	System.out.println("Waiting queue contains customer " + waitingCustomer);
	if (this.balanceAmount >= Math.abs(waitingCustomer.getInfo().value)) {
	    waitingCustomer = largeWithdrawCustomers.dequeue();
	    this.balanceAmount -= Math.abs( waitingCustomer.getInfo().value);
	} else {
	    // KEEP WAITING TILL THE BALANCE IS BUILT UP....
	    this.requestHandler(largeWithdrawCustomers, bankCustomersQueue);
	}
    }

    /**
     * HANDLES THE REQUEST FOR THE NORMAL QUEUE
     * 
     * @param largeWithdrawCustomers
     * @param bankCustomersQueue
     * 
     */
    private void requestHandler(Queue<Customer> largeWithdrawCustomers, Queue<Customer> bankCustomersQueue) {
	Node<Customer> currentCustomer = bankCustomersQueue.dequeue();
	if (currentCustomer == null) {
	    return;
	}
	System.out.println("The number of customer in the queue are : " + bankCustomersQueue.size());
	System.out.println("normal queue entry : removal :: " + currentCustomer);
	long requestMoney =  currentCustomer.getInfo().value;
	if (requestMoney > 0) {
	    balanceAmount += requestMoney;
	} else {
	    if (this.balanceAmount >= Math.abs(requestMoney)) {
		this.balanceAmount -= Math.abs(requestMoney);
	    } else {
		// THE MONEY REQUESTED IS LARGER PUT HIM IN THE WAITING QUEUE
		largeWithdrawCustomers.enqueue(currentCustomer);
		System.out.println("customer has entered the waiting queue : " + largeWithdrawCustomers.size());
	    }
	}
    }

    /**
     * ADDS THE CUSTOMERS TO THE BANKCUSTOMERQUEUE
     * 
     * @param bankCustomersQueue
     * 
     */
    private void addCustomers(Queue<Customer> bankCustomersQueue) {
	// CREATES NODE OBJECT CUSTOMER AND ADDS IT TO THE QUEUE
	Node<Customer> customer = new Node<Customer>();
	System.out.println("Enter with sign to deposit or (-)withdraw or deposit");
	
	Customer validCustomer=new Customer();
	validCustomer.value=Utility.getLongValue();
	customer.setInfo(validCustomer);
	bankCustomersQueue.enqueue(customer);

    }

}
