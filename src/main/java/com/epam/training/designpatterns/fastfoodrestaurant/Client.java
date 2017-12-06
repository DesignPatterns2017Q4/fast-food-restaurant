package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Client implements Observer {
	
	private String name;
	private double happiness;
	Cashier cashier;
	
	public Client(String name) {
		this.happiness = 1.0;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public void makeOrder(Order order) {
		cashier.newOrder(order);
	}

	public void consumeOrder(Order order) {
		Product product = order.getProduct();
		List<Extra> extras = order.getExtras();
		applyExtras(product, extras);
		printEating(product, extras);
		product.consumedBy(this);
		System.out.println("I am " + this.happiness + " happy.");
	}

	private void printEating(Product product, List<Extra> extras) {
		System.out.print(this.name + ": ");
		System.out.print("Consuming " + product.getName() + " ");
		if(!extras.isEmpty()) {
			System.out.print("with extras: ");
			for(Extra e : extras) {
				System.out.print(e.getName() + " ");
			}
		}
		System.out.println();
	}
	
	public boolean isMyOrder(Order order) {
		return order.getClient().getName().equals(this.name);
	}

	private void applyExtras(Product product, List<Extra> extras) {
		for(Extra e : extras) {
			e.modifyEffectOfProduct(product);
		}
	}

	public double getHappiness() {
		return happiness;
	}

	public void setHappiness(double d) {
		this.happiness = d;
	}

	public void update(Observable o, Object arg) {
		if(isMyOrder((Order)arg)) {
			consumeOrder((Order)arg);
		}
	}
	
}
