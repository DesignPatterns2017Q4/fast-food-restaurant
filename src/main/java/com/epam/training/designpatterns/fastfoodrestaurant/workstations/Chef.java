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
	
	private OrderQueue orderQueue;
	private DeliveryQueue deliveryQueue;
	private boolean isBusy;
	private int cookingSpeed = 1000;

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
		
		int preparationTime = isPriority ? cookingSpeed : cookingSpeed + 1000;
		
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
	
	public void setCookingSpeed(int cookingSpeed) {
		this.cookingSpeed = cookingSpeed;
	}


}
