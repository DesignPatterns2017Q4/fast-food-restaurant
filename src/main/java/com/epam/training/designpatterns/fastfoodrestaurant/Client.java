package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Collection;
import java.util.List;
import java.util.Set;
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
	
	public void receive(Order order) {
		Product product = order.getProduct();
		List<Extra> extras = order.getExtras();
		
		consume(product, extras);
	}

	private void consume(Product product, List<Extra> extras) {
		System.out.println("Consuming " + product);
		product.consumedBy(this);
		System.out.println("I am " + this.happiness + " happy.");
		
		for(Extra e : extras) {
			System.out.print("Consuming ");
			System.out.println(e);
			System.out.println("I am " + this.happiness + " happy.");
		}
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
}
