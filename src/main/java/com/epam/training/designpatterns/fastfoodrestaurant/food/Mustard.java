package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mustard extends Condiment implements Food {

	public Mustard(Food baseFood) {
		super(baseFood);
	}
	
	public Mustard() { }

	@Override
	public int applyEffect(int happiness) {
		if (baseFood != null) {
			return happiness + 1;
		}
		else {
			throw new RuntimeException("Cannot measure effect of a condiment on its own!");
		}
	}
	
	@Override
	public String toString() {
		return "Mustard " + baseFood.toString();
	}
}
