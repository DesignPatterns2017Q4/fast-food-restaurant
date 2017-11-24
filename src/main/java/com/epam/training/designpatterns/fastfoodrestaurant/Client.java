package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.UUID;

public class Client {
	
	private int happiness;
	Order order;
	
	public Client() {
		this.happiness = 0;
	}

	void sendOrderToServer(Server server) {
		server.takeOrder(order);
	}
	
	public void consume(Order order) {
		
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
}
