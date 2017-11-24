package com.epam.training.designpatterns.fastfoodrestaurant;

public class Client {
	
	private int happiness;
	Order order;
	Server server;
	
	public Client(Server server) {
		super();
		this.happiness = 0;
		this.server = server;
	}

	void makeOrder() {
		server.sendOrderToQueue(order);
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
