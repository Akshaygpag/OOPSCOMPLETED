
package com.message.operation;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Akshay
 * @version 1.0.0
 * @since 02-Jun-2018
 */
public class MainClassClient {

	static Socket socket;

	public static void main(String[] args) {

		
		try {
			socket = new Socket("localhost", 8080);
	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
//		socket.getOutputStream().write(65);
//		socket.getOutputStream().flush();

		
		Runnable client = () -> {

		
		
		
		};

		
		
		
	}

}
