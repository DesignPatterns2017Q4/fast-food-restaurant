package com.epam.training.designpatterns.fastfoodrestaurant.entities;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public class ReadyMeal {

	private final Food food;
	private final Client client;
	
	public Food getFood() {
		return food;
	}

	public Client getClient() {
		return client;
	}

	public ReadyMeal(Food food, Client client) {
		this.food = food;
		this.client = client;
	}
	
}
