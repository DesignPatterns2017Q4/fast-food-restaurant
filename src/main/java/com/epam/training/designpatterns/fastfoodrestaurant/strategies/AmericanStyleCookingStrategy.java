package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public class AmericanStyleCookingStrategy implements CookingStrategy {

	@Override
	public void prepare(Food food) {
		System.out.printf("Perparing %s the American style: with Coke & french fries!%n", food);
	}
	
}
