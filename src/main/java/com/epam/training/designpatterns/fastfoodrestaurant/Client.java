package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.List;

public class Client {
	
	private int happiness;
	Cashier cashier;
	
	public Client(Cashier cashier) {
		this.happiness = 0;
		this.cashier = cashier;
	}

	public void makeOrder(Order order) {
		cashier.newOrder(order);
	}

	public void consumeOrder(Order order) {
		Product product = order.getProduct();
		List<Extra> extras = order.getExtras();
		applyExtras(product, extras);
		
		System.out.println("Consuming " + product.getName());
		product.consumedBy(this);
		System.out.println("I am " + this.happiness + " happy");
	}

	private void applyExtras(Product product, List<Extra> extras) {
		for(Extra e : extras) {
			e.modifyEffectOfProduct(product);
		}
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	
}
