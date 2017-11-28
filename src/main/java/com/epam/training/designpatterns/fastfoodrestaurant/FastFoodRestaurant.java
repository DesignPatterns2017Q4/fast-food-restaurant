package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;
import java.util.List;

public class FastFoodRestaurant {

	public static void main(String[] args) throws InterruptedException {
		
		Cashier cashier = new Cashier();
		Robot robot = new Robot(cashier);
		Client client = new Client(cashier);
		
		cashier.setRobot(robot);
		
		List<Extra> extras = new LinkedList<Extra>();
		extras.add(new Ketchup());
		extras.add(new Mustard());
		
		Order order = new Order(client, new HotDog(), extras);
		
		client.makeOrder(order);
	}

}
