package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FastFoodRestaurant {

	public static void main(String[] args) throws InterruptedException {
		
		Cashier cashier = new Cashier();
		Robot robot = new Robot();
		Client firstClient = new Client("first client");
		Client secondClient = new Client("second client");
		Client thirdClient = new Client("third client");
		Queue<Order> newOrderQueue = new ConcurrentLinkedQueue<Order>();
		Queue<Order> readyOrderQueue = new ConcurrentLinkedQueue<Order>();
		
		cashier.setRobot(robot);
		cashier.setNewOrderQueue(newOrderQueue);
		cashier.setReadyOrderQueue(readyOrderQueue);
		cashier.addObserver(firstClient);
		cashier.addObserver(secondClient);
		cashier.addObserver(thirdClient);
		
		robot.setCashier(cashier);
		robot.setNewOrderQueue(newOrderQueue);
		robot.setReadyOrderQueue(readyOrderQueue);
		robot.addObserver(cashier);
		
		firstClient.setCashier(cashier);
		secondClient.setCashier(cashier);
		thirdClient.setCashier(cashier);
		
		List<Extra> firstClientExtras = new LinkedList<Extra>();
		firstClientExtras.add(new Ketchup());
		firstClientExtras.add(new Mustard());
		
		List<Extra> secondClientExtras = new LinkedList<Extra>();
		secondClientExtras.add(new Ketchup());
		
		List<Extra> thirdClientExtras = new LinkedList<Extra>();
		thirdClientExtras.add(new Ketchup());
		
		Order firstClientOrder = new Order(firstClient, new HotDog(), firstClientExtras);
		Order secondClientOrder = new Order(secondClient, new Chips(), secondClientExtras);
		Order thirdClientOrder = new Order(thirdClient, new HotDog(), thirdClientExtras);

		Thread kitchen = new Thread(robot);
		kitchen.start();
		
		firstClient.makeOrder(firstClientOrder);
		secondClient.makeOrder(secondClientOrder);
		thirdClient.makeOrder(thirdClientOrder);

	}

}
