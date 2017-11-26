package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.Observable;
import java.util.Observer;

import com.epam.training.designpatterns.fastfoodrestaurant.Restaurant;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;


public class Waiter implements Observer {

	private static final int MAX_TIME_TO_DELIVER_MEAL = 1500;
	private static final int MAX_TIME_TO_TAKE_ORDER = 2200;
	
	private OrderQueue orderQueue;
	private DeliveryQueue deliveryQueue;
	private boolean isBusy;
	
	public Waiter(OrderQueue orderQueue, DeliveryQueue deliveryQueue) {
		this.orderQueue = orderQueue;
		this.deliveryQueue = deliveryQueue;
		deliveryQueue.addObserver(this);
	}

	public void takeOrder(Order order) {
		try {
			System.out.printf("Waiter: Taking next order...(from client: %s)%n", order.getClient());
			Thread.sleep(1000 + Restaurant.random.nextInt(MAX_TIME_TO_TAKE_ORDER));
		} catch (InterruptedException e) {}
		orderQueue.addOrder(order);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!isBusy) {
			try {
				deliverMeals();
			} catch (InterruptedException e) {}
		}
	}

	private void deliverMeals() throws InterruptedException {
		while (!deliveryQueue.isEmpty()) {
			isBusy = true;
			ReadyMeal meal = deliveryQueue.getNextMeal();
			System.out.printf("Waiter: Delivering order... (for client: %s)%n", meal.getClient());
			Thread.sleep(1000 + Restaurant.random.nextInt(MAX_TIME_TO_DELIVER_MEAL));
			Client client = meal.getClient();
			client.consumeFood(meal.getFood());
		}
		isBusy = false;
	}
	
}
