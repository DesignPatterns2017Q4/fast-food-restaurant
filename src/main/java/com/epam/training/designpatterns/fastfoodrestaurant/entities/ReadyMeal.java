package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public class ReadyMeal {

	private final Food readyMeal;
	private final Client client;
	
	public Food getReadyFood() {
		return readyMeal;
	}

	public Client getClient() {
		return client;
	}

	public ReadyMeal(Food food, Client client) {
		this.readyMeal = food;
		this.client = client;
	}
	
}
