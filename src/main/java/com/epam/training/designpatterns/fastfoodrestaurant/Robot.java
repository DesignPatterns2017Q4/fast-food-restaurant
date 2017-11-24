package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Random;

public class Robot {
	
	Order order;
	Server server;
	Random random;
	
	public void takeOrder(Order order) {
		this.order = order;
		prepareOrder();
	}
	
	public void prepareOrder() {
		takeSomeTime();
		server.giveProductsToClient(order);
	}

	private void takeSomeTime() {
		this.random = new Random();
	}
}
