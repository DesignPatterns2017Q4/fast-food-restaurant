package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public class DefaultCookingStrategy implements CookingStrategy {

	@Override
	public void prepare(Food food) {
		System.out.printf("Doing nothing special, just preparing %s really well!%n", food);
	}
	
}
