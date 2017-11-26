package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Random;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Chips;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Hotdog;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Ketchup;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Mustard;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

public class Restaurant {

	private static final int MAX_TIME_TO_SPAWN_NEW_CLIENT = 5000;
	public static final Random random = new Random();
	
	private OrderQueue orderQueue = new OrderQueue();
	private DeliveryQueue deliveryQueue = new DeliveryQueue();
	private Chef chef = new Chef(orderQueue, deliveryQueue);
	private Waiter waiter = new Waiter(orderQueue, deliveryQueue);
	
	
	public void startSimulation(int maxNumberOfClients) throws InterruptedException {
		int clientSoFar = 0;
		while (maxNumberOfClients > clientSoFar) {
			new Thread(new SimulatedClient()).start();
			Thread.sleep(1000 + random.nextInt(MAX_TIME_TO_SPAWN_NEW_CLIENT));
			clientSoFar++;
		}
	}
	
	private class SimulatedClient implements Runnable {

		@Override
		public void run() {
			Client client = new Client(waiter);
			Order order = generateRandomOrder(client);
			client.orderFood(order);
		}
		
		private Order generateRandomOrder(Client client) {
			Food food = random.nextInt(100) > 50 ? new Chips() : new Hotdog();
			Condiment condiment = random.nextInt(100) > 50 ? new Ketchup() : new Mustard();
			boolean priority = random.nextInt(100) > 50;
			Order order = new Order.OrderBuilder(client, food)
					.addCondiment(condiment)
					.setPriority(priority)
					.build();
			return order;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Restaurant restaurant = new Restaurant();
		restaurant.startSimulation(10);

	}

}
