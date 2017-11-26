package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Deque;
import java.util.LinkedList;

public class Server implements Runnable {

	Robot robot;
	Deque<Order> queue;
	
	public Server(Client client, Robot robot, Order order) {
		this.robot = robot;
		queue = new LinkedList<Order>();
	}
	
	public void newOrder(Order order) {
		queue.push(order);
		notifyAll();
	}
	
	public void foodReady(Order order) {
		Client client = order.getClient();
		client.receive(order);
	}

	public void run() {
		
	}
}
