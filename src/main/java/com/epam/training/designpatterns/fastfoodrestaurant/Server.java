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
	
	public void takeOrder(Order order) {
		queue.push(order);
		notifyAll();
	}
	
	public void giveProductsToClient(Order order, Client client) {
		client.consume(order);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}
