package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Client;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;
import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Condiment;
import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.CookingStrategy;
import com.epam.training.designpatterns.fastfoodrestaurant.strategies.DefaultCookingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Chef implements Observer {

	private static final Logger logger = LoggerFactory.getLogger("Chef");
	private static final Random random = new Random();
	
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
		prepareForCooking(order);
		return createReadyMeal(order);
	}

	private void prepareForCooking(Order order) throws InterruptedException {
		int preparationTime = order.isPriority() ? cookingSpeed : cookingSpeed + 1000;
		logger.info("Preparing next meal (for: {}, priority: {})", order.getClient(), order.isPriority());
		Thread.sleep(random.nextInt(preparationTime));
	}

	private Food createReadyMeal(Order order) {
		Food assembledFood = assembleIngredients(order);
		Food finishedMeal = prepareFoodWithStyle(assembledFood, order.getCookingStyle());
		return finishedMeal;
	}

	private Food assembleIngredients(Order order) {
		Food assembledFood = order.getFood();
		for (Class<? extends Condiment> condiment : order.getCondiments()) {
			try {
				assembledFood = condiment.getDeclaredConstructor(Food.class).newInstance(assembledFood);
			} catch (InstantiationException|IllegalAccessException|NoSuchMethodException|InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return assembledFood;
	}

	private Food prepareFoodWithStyle(Food food, CookingStrategy cookingStrategy) {
		setCookingStrategy(cookingStrategy);
		logger.info(this.cookingStrategy.getRecipe(), food);
		return food;
	}

	public void setCookingSpeed(int cookingSpeed) {
		if (cookingSpeed > 0) {
			this.cookingSpeed = cookingSpeed;
		} else {
			logger.warn("Cannot set cooking speed to: {}. Value must be positive!", cookingSpeed);
		}
	}

	public int getCookingSpeed() {
		return cookingSpeed;
	}

	public void setCookingStrategy(CookingStrategy cookingStrategy) {
		if (cookingStrategy != null) {
			this.cookingStrategy = cookingStrategy;
		} else {
			logger.warn("Cannot set cooking style to null! Leaving cooking style on original value.");
		}
	}
}
