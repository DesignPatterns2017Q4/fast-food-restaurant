package com.epam.training.designpatterns.fastfoodrestaurant;

public class Robot {
	
	Cashier cashier;
	
	public Robot(Cashier cashier) {
		this.cashier = cashier;
	}
	
	public void serveOrder(Order order) {
		cashier.foodReady(order);
	}

}
