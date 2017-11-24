package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Deque;
import java.util.LinkedList;

public class Server {

	Robot robot;
	Deque<Order> queue;
	
	public Server(Client client, Robot robot, Order order) {
		this.robot = robot;
		queue = new LinkedList<Order>();
	}
	
	public void sendOrderToQueue(Order order, Deque<Order> queue) {
		robot.takeOrder(order);
	}
	
	public void giveProductsToClient(Order order, Client client) {
		client.consume(order);
	}
}
