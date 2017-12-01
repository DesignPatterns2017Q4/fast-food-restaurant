package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Observer;

public class Cashier extends Observable implements Observer {

	Robot robot;
	OrderQueue orderQueue;

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public void setOrderQueue(OrderQueue orderQueue) {
		this.orderQueue = orderQueue;
	}

	public void newOrder(Order order) {
		robot.serveOrder(order);
	}

	public void update(Observable o, Object arg) {
		Order order = orderQueue.pop();
		setChanged();
		notifyObservers(order);
	}

}
