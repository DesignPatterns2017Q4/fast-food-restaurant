package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Observer;

public class Cashier extends Observable implements Observer {

	Robot robot;
	OrderQueue newOrderQueue;
	OrderQueue readyOrderQueue;

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	public void setNewOrderQueue(OrderQueue newOrderQueue) {
		this.newOrderQueue = newOrderQueue;
	}

	public void setReadyOrderQueue(OrderQueue readyOrderQueue) {
		this.readyOrderQueue = readyOrderQueue;
	}

	public void newOrder(Order order) {
		newOrderQueue.put(order);
	}

	public void update(Observable o, Object arg) {
		Order order = readyOrderQueue.pop();
		setChanged();
		notifyObservers(order);
	}

}
