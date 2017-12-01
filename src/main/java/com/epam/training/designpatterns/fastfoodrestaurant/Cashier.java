package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Observable;
import java.util.Observer;

public class Cashier extends Observable implements Observer {

	Robot robot;

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public void newOrder(Order order) {
		robot.serveOrder(order);
	}

	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);
	}

}
