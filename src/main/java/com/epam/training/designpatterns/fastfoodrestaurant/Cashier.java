package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Observer;
import java.util.Queue;

public class Cashier extends Observable implements Observer {

	Robot robot;
	Queue<Order> newOrderQueue;
	Queue<Order> readyOrderQueue;

	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	public void setNewOrderQueue(Queue<Order> newOrderQueue2) {
		this.newOrderQueue = newOrderQueue2;
	}

	public void setReadyOrderQueue(Queue<Order> readyOrderQueue2) {
		this.readyOrderQueue = readyOrderQueue2;
	}

	public void newOrder(Order order) {
		newOrderQueue.add(order);
	}

	public void update(Observable o, Object arg) {
		Order order = readyOrderQueue.remove();
		setChanged();
		notifyObservers(order);
	}

}
