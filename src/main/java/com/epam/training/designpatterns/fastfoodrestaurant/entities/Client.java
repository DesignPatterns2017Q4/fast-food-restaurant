package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import java.util.concurrent.atomic.AtomicInteger;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.workstations.Waiter;

public class Client {
	
	private static AtomicInteger nextId = new AtomicInteger(1);
	
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
		System.out.printf("%s: Eating food: %s. New happiness score: %d%n", this, food, happiness);
	}
	
	public int getHappiness() {
		return happiness;
	}

	@Override
	public String toString() {
		return "Client [ID=" + clientId + "]";
	}
	
}
