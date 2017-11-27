package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Queue;

public class Cashier implements Runnable {

	Robot robot;
	Queue<Order> queue;
	int capacity;
	
	public Cashier(Queue<Order> queue) {
		this.queue = queue;
	}
	
	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public void newOrder(Order order) throws InterruptedException {
		while(queue.size() == capacity) {
		    wait();
		}
		queue.add(order);
		notifyAll();
	}
	
	public void foodReady(Order order) {
		Client client = order.getClient();
		client.receiveOrder(order);
	}

	public void run() {
		
	}
}
