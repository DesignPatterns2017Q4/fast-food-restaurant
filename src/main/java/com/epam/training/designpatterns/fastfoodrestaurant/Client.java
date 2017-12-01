package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {
	
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
		
		System.out.print("Consuming " + product.getName() + " ");
		
		if(!extras.isEmpty()) {
			System.out.print("with extras: ");
			for(Extra e : extras) {
				System.out.print(e.getName() + " ");
			}
		}
		System.out.println();
		
		product.consumedBy(this);
		System.out.println("I am " + this.happiness + " happy.");
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

	public void update(Observable o, Object arg) {
		consumeOrder((Order)arg);
	}
	
}
