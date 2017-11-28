package com.epam.training.designpatterns.fastfoodrestaurant;

public class Cashier {

	Robot robot;

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public void newOrder(Order order) {
		robot.serveOrder(order);
	}
	
	public void foodReady(Order order) {
		order.getClient().consumeOrder(order);
	}

}
