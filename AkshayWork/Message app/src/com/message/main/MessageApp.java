package com.message.main;
import java.util.Scanner;
public class MessageApp {
	final MailBox box = MailBox.getMailBox();
	static final MessageApp app = new MessageApp();
	Runnable client = () -> {

		while (true) {
			synchronized (box) {
				while (!box.getContainer().isEmpty()) {
					String message = box.getContainer().poll();
					System.out.println(message + "  --read by "
							+ Thread.currentThread().getName());
				}
				System.out.println(
						"Enter message " + Thread.currentThread().getName());
				box.getContainer().add(app.getMessage());
				try {
					box.notify();
					box.wait();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	};

	Runnable server = () -> {

		while (true) {

			synchronized (box) {

				while (!box.getContainer().isEmpty()) {
					String message = box.getContainer().poll();
					System.out.println(message + "  --read by "
							+ Thread.currentThread().getName());
				}
				System.out.println(
						"Enter message " + Thread.currentThread().getName());
				box.getContainer().add(app.getMessage());
				try {
					box.notify();
					box.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	};
	public static void main(String[] args) {
		app.setStart();
	}

	public String getMessage() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public void setStart() {
		Thread one = new Thread(client);
		one.setName("Player 1");
		one.start();
		try {
			one.join(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread two = new Thread(server);
		two.setName("Player 2");
		two.start();
	}

}
