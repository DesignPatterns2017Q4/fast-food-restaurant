package com.epam.training.designpatterns.fastfoodrestaurant.food;

public abstract class Condiment implements Food {
	
	protected Food baseFood;

	protected Condiment(Food baseFood) {
		this.baseFood = baseFood;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + baseFood.toString();
	}

	@Override
	public int applyEffect(int happiness) {
		return happiness;
	}
}
