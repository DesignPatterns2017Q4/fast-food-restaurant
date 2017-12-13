package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import java.util.concurrent.atomic.AtomicInteger;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
	
	private static AtomicInteger nextId = new AtomicInteger(1);
	private static final Logger logger = LoggerFactory.getLogger("Client");
	
	private int clientId;
	private int happiness;
	private Waiter waiter;
	
	public Client(Waiter waiter) {
		this.clientId = nextId.get();
		nextId.incrementAndGet();
		this.waiter = waiter;
		happiness = 100;
	}
	
	public void orderFood(Order order) {
		waiter.takeOrder(order);
	}
	
	public void consumeFood(Food food) {
		happiness = food.applyEffect(happiness);
		logger.info("{}: Eating food: {}. New happiness percentage: {}%", this, food, happiness);
	}
	
	public int getHappiness() {
		return happiness;
	}

	@Override
	public String toString() {
		return "Client [ID=" + clientId + "]";
	}
	
}
