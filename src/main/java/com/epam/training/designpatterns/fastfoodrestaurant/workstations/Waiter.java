package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.Observable;
import java.util.Observer;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;


public class Waiter implements Observer {
	
	private OrderQueue orderQueue;
	private DeliveryQueue deliveryQueue;
	private boolean isBusy;
	private int deliverySpeed = 1000;
	private int orderTakingSpeed = 1000;
	
	
	public Waiter(OrderQueue orderQueue, DeliveryQueue deliveryQueue) {
		this.orderQueue = orderQueue;
		this.deliveryQueue = deliveryQueue;
		deliveryQueue.addObserver(this);
	}

	public void takeOrder(Order order) {
		try {
			System.out.printf("Waiter: Taking next order...(from: %s)%n", order.getClient());
			Thread.sleep(orderTakingSpeed);
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
			System.out.printf("Waiter: Delivering order... (for: %s)%n", meal.getClient());
			Thread.sleep(deliverySpeed);
			Client client = meal.getClient();
			client.consumeFood(meal.getReadyFood());
		}
		isBusy = false;
	}
	
	public void setDeliverySpeed(int deliverySpeed) {
		this.deliverySpeed = deliverySpeed;
	}

	public void setOrderTakingSpeed(int orderTakingSpeed) {
		this.orderTakingSpeed = orderTakingSpeed;
	}
	
}
