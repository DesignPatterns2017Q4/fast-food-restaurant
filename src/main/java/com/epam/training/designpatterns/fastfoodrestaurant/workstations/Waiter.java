package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Waiter implements Observer {

	private static final Logger logger = LoggerFactory.getLogger("Waiter");
	private static final Random random = new Random();

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
			logger.info("Taking next order...(from: {})", order.getClient());
			Thread.sleep(random.nextInt(orderTakingSpeed));
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
			logger.info("Delivering order... (for: {})", meal.getClient());
			Thread.sleep(random.nextInt(deliverySpeed));
			Client client = meal.getClient();
			client.consumeFood(meal.getReadyFood());
		}
		isBusy = false;
	}
	
	public void setDeliverySpeed(int deliverySpeed) {
		if (deliverySpeed > 0) {
			this.deliverySpeed = deliverySpeed;
		} else {
			logger.warn("Cannot set delivery speed to: {}. Value must be positive!", deliverySpeed);
		}
	}

	public void setOrderTakingSpeed(int orderTakingSpeed) {
		if (orderTakingSpeed > 0) {
			this.orderTakingSpeed = orderTakingSpeed;
		} else {
			logger.warn("Cannot set order taking speed to: {}. Value must be positive!", orderTakingSpeed);
		}

	}

	public int getDeliverySpeed() {
		return deliverySpeed;
	}

	public int getOrderTakingSpeed() {
		return orderTakingSpeed;
	}
}
