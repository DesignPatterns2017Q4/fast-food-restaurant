package com.epam.training.designpatterns.fastfoodrestaurant.strategies;

public class JapaneseStyleCookingStrategy implements CookingStrategy {

	@Override
	public String getRecipe() {
		return "Preparing {} the Japanese style: with seafood and rice on the side!";
	}
	
}
