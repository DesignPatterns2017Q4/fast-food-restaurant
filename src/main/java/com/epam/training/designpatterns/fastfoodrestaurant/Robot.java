package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Deque;
import java.util.Random;

public class Robot implements Runnable {
	
	Order order;
	Server server;
	Random random;
	int millis;
	Deque<Order> orders;
	
	public void takeOrderFromQueue(Deque<Order> orders) throws InterruptedException {
		this.order = orders.pop();
		prepareOrder();
	}
	
	public void prepareOrder() throws InterruptedException {
		takeSomeTime();
		server.giveProductsToClient(order, null);
	}

	private void takeSomeTime() throws InterruptedException {
		millis = random.nextInt(5000);
		Thread.sleep(millis);
	}

	public void run() {
		try {
			takeOrderFromQueue(orders);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
