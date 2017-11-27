package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		
		Client client = new Client();		
		Queue<Order> queue = new LinkedList<Order>();
		int capacity = 
		Cashier cashier = new Cashier(queue);
		Robot robot = new Robot(queue);
		cashier.setRobot(robot);
		robot.setCashier(cashier);
		
		Product product = new HotDog();
		Extra extra = new Ketchup();
		List<Extra> listOfExtras = new ArrayList<Extra>();
		listOfExtras.add(extra);
		Order order = new Order(client, product, listOfExtras);
		
		client.initiateOrder(cashier);
	}

}
