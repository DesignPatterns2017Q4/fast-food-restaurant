package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public class Chef implements Observer {
	
	private static final int MAX_TIME_TO_PREPARE_NONPRIORITY_MEAL = 5000;
	private static final int MAX_TIME_TO_PREPARE_PRIORITY_MEAL = 2800;
	private OrderQueue orderQueue;
	private DeliveryQueue deliveryQueue;
	private boolean isBusy;
	
	public Chef(OrderQueue orderQueue, DeliveryQueue deliveryQueue) {
		this.orderQueue = orderQueue;
		this.deliveryQueue = deliveryQueue;
		orderQueue.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (!isBusy) {
			try {
				prepareOrders();
			} catch (InterruptedException e) { }
		}
	}
	
	public void prepareOrders() throws InterruptedException {
		while (!orderQueue.isEmpty()) {
			isBusy = true;
			Order order = orderQueue.getNextOrder();
			Client client = order.getClient();
			Food food = buildFood(order);
			
			ReadyMeal meal = new ReadyMeal(food, client);
			deliveryQueue.addFinishedMeal(meal);
		}
		isBusy = false;
	}

	private Food buildFood(Order order) throws InterruptedException {
		
		Food baseFood = order.getFood();
		List<Condiment> condiments = order.getCondiments();
		boolean isPriority = order.isPriority();
		
		int preparationTime = 1000 + (isPriority ? MAX_TIME_TO_PREPARE_PRIORITY_MEAL : 
			MAX_TIME_TO_PREPARE_NONPRIORITY_MEAL);
		
		System.out.printf("Chef: Preparing next meal (for client: %s, priority: %s)%n"
				, order.getClient(), order.isPriority());
		Thread.sleep(preparationTime);
		
		Food finishedMeal = baseFood;
		for (Condiment condiment : condiments) {
			condiment.setBaseFood(finishedMeal);
			finishedMeal = (Food) condiment;
		}
		
		return finishedMeal;
	}

}
