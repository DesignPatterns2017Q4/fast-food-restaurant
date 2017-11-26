package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mayonnaise extends Condiment implements Food {

	@Override
	public int applyEffect(int happiness) {
		return (int) (baseFood.applyEffect(happiness) * 0.9);
	}
	
	@Override
	public String toString() {
		return "Mayonnaise " + baseFood.toString();
	}
	
}
