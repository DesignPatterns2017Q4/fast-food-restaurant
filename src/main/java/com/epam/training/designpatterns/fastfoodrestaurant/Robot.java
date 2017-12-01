package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;

public class Robot extends Observable {
	
	Cashier cashier;
	
	public Robot(Cashier cashier) {
		this.cashier = cashier;
	}
	
	public void serveOrder(Order order) {
		setChanged();
		notifyObservers(order);
	}

}
