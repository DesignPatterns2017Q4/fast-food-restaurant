package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

public class AmericanStyleCookingStrategy implements CookingStrategy {

	@Override
	public String getRecipe() {
		return "Preparing {} the American style: with Coke & french fries!";
	}
	
}
