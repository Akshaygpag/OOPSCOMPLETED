/**
 * @author Akshay
 * @version 1.0.0
 * @since 02-Jun-2018
 */

package com.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author bridgeit
 *
 */
public class MainClass extends JFrame {
	
	static boolean SEND;
	final DataOutputStream dataSend;
	final Socket socket;
	final DataInputStream dataRecieve;
	static JButton submit;
	static JTextField field;
	static String latestMessage="";
	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 * 
	 */

	public MainClass() throws UnknownHostException, IOException {
		super("Chat box");
		socket = new Socket("localhost", 8080);
		dataSend = new DataOutputStream(socket.getOutputStream());
		dataRecieve = new DataInputStream(socket.getInputStream());
	}
	public static void main(String[] args)
			throws UnknownHostException, IOException {

		MainClass main = new MainClass();
		System.out.println("Enter your name");
		Scanner scan = new Scanner(System.in);

		main.startChat(scan.nextLine());
	}

	/**
	 * @throws IOException
	 * 
	 * 
	 */
	private void startChat(String name) throws IOException {

		Panel thePanel = new Panel();

		thePanel.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 300, 300);
		JTextArea textArea = new JTextArea(30, 50);

		textArea.setBackground(Color.WHITE);

		textArea.setBorder(BorderFactory.createTitledBorder("History"));
		textArea.setAutoscrolls(true);
		textArea.setEditable(false);
		thePanel.add(textArea);

		field = new JTextField(50);
		latestMessage=field.getText();
		field.setFocusable(true);
		field.setToolTipText("input area");
		JPanel panel = new JPanel();
		submit = new JButton();
		
		submit.setText("Submit");
		panel.add(field,BorderLayout.SOUTH);
		submit.addActionListener(new SubmitListner(field.getText()));
		System.out.println("-------------------");
		
		
System.out.println(field.getText());		
		
		System.out.println("-------------------");

		panel.add(submit,BorderLayout.SOUTH);

		thePanel.add(panel);
		this.add(thePanel);
		this.setVisible(true);
		Chathandler chat = new Chathandler();
		Thread send = new Thread(chat);
		send.setName(name);
		Reciever recievemessages = new Reciever();

		Thread recieve = new Thread(recievemessages);
		send.start();
		recieve.start();

	}

	class Chathandler implements Runnable {

		Scanner scan = new Scanner(System.in);
		@Override
		public void run() {

			while (true) {
// = scan.nextLine();
				while(!MainClass.SEND) {
					
					System.out.println("looping in");
				}
				
				System.out.println("++++++++++++++");
				String message=MainClass.field.getText();
				MainClass.SEND=false;
				try {
					dataSend.writeUTF(message + " .........."
							+ Thread.currentThread().getName());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

	class Reciever implements Runnable {

		@Override
		public void run() {
			while (true) {
				String message;
				try {
					message = dataRecieve.readUTF();
					System.out.println(message);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}

class SubmitListner implements ActionListener {

	String latestmessage;
	
	public SubmitListner(String obj) {
		latestmessage=obj;
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(MainClass.submit)) {
MainClass.SEND=true;
//			System.out.println("Entered submit button");
//			System.out.println(this.latestmessage);			
//			System.out.println();
		}

	}

}



class TextAcquire implements KeyListener{
StringBuffer sb=new StringBuffer();
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// bridgeit 
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// bridgeit 
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// bridgeit 
		
	}
	
	
	
}
