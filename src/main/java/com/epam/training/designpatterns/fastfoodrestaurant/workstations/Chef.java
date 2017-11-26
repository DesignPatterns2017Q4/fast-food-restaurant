package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.CookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.DefaultCookingStrategy;

public class Chef implements Observer {
	
	private OrderQueue orderQueue;
	private DeliveryQueue deliveryQueue;
	private CookingStrategy cookingStrategy = new DefaultCookingStrategy();
	private boolean isBusy;
	private int cookingSpeed = 1000;

	public Chef(OrderQueue orderQueue, DeliveryQueue deliveryQueue) {
		this.orderQueue = orderQueue;
		this.deliveryQueue = deliveryQueue;
		orderQueue.addObserver(this);
	}
	
	public Chef(OrderQueue orderQueue, DeliveryQueue deliveryQueue, CookingStrategy cookingStrategy) {
		this(orderQueue, deliveryQueue);
		this.cookingStrategy = cookingStrategy;
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
			Food food = prepareFood(order);
			
			ReadyMeal meal = new ReadyMeal(food, client);
			deliveryQueue.addFinishedMeal(meal);
		}
		isBusy = false;
	}

	private Food prepareFood(Order order) throws InterruptedException {
		
		Food baseFood = order.getFood();
		List<Condiment> condiments = order.getCondiments();
		boolean isPriority = order.isPriority();
		CookingStrategy cookingStrategy = order.getCookingStyle();
		
		int preparationTime = isPriority ? cookingSpeed : cookingSpeed + 1000;
		
		System.out.printf("Chef: Preparing next meal (for: %s, priority: %s)%n", order.getClient(), isPriority);
		
		Thread.sleep(preparationTime);
		
		Food finishedMeal = baseFood;
		for (Condiment condiment : condiments) {
			condiment.setBaseFood(finishedMeal);
			finishedMeal = (Food) condiment;
		}
		
		setCookingStrategy(cookingStrategy);
		cookingStrategy.prepare(finishedMeal);
		setCookingStrategy(new DefaultCookingStrategy());
		
		return finishedMeal;
	}
	
	public void setCookingSpeed(int cookingSpeed) {
		this.cookingSpeed = cookingSpeed;
	}
	
	public void setCookingStrategy(CookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}

}
