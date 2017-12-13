package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

public class DefaultCookingStrategy implements CookingStrategy {

	@Override
	public String getRecipe() {
		return "Doing nothing special, just preparing {} really well!";
	}
}
