package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

import com.epam.training.designpatterns.fastfoodrestaurant.food.Food;

public interface CookingStrategy {

	void prepare(Food food);
	
}
