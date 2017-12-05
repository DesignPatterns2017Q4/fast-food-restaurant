package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Chips;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Hotdog;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Ketchup;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Mustard;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.AmericanStyleCookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.CookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.JapaneseStyleCookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Chef;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.DeliveryQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.OrderQueue;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

public class RestaurantSimulator {

	public static final Random random = new Random();
	
	private OrderQueue orderQueue = new OrderQueue();
	private DeliveryQueue deliveryQueue = new DeliveryQueue();
	private Chef chef = new Chef(orderQueue, deliveryQueue, new AmericanStyleCookingStrategy());
	private Waiter waiter = new Waiter(orderQueue, deliveryQueue);
	
	
	public static void main(String[] args) throws InterruptedException {
		RestaurantSimulator restaurant = new RestaurantSimulator();
		restaurant.startSimulation(20, 4000);
	}
	
	
	public void startSimulation(int maxNumberOfClients, int maxSpawnTime) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < maxNumberOfClients; ++i) {
			executor.submit(new SimulatedClient());
			Thread.sleep(maxSpawnTime);
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
			CookingStrategy cookingStyle = random.nextInt(100) > 50 ? 
					new AmericanStyleCookingStrategy() : new JapaneseStyleCookingStrategy();
			Order order = new Order.OrderBuilder(client, food)
					.withCondiment(condiment)
					.withCookingStyle(cookingStyle)
					.withPriority(priority)
					.build();
			return order;
		}
	}
	


}
