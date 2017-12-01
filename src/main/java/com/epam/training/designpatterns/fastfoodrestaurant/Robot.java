package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;

public class Robot extends Observable {
	
	Cashier cashier;
	OrderQueue orderQueue;
	
	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
	public void setOrderQueue(OrderQueue orderQueue) {
		this.orderQueue = orderQueue;
	}
	
	public void serveOrder(Order order) {
		orderQueue.put(order);
		setChanged();
		notifyObservers(order);
	}

}
