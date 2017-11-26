package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public class JapaneseStyleCookingStrategy implements CookingStrategy {

	@Override
	public void prepare(Food food) {
		System.out.printf("Preparing %s the Japanese style: with seafood and rice on the side!%n", food);
	}
	
}
