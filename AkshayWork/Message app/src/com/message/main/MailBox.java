package com.message.main;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class MailBox implements Serializable {

	private static final long serialVersionUID = 1L;
	private static MailBox box = new MailBox();
	private Queue<String > container=new LinkedList<String>();
	public static MailBox getMailBox() {
		return box;

	}

	private MailBox() {	}



	/**
	 * @return
	 * 
	 */
	public Queue<String> getContainer() {
		return this.container;
	}



}
