package com.epam.training.designpatterns.fastfoodrestaurant.food;

public abstract class Condiment {
	
	protected Food baseFood;

	protected Condiment(Food baseFood) {
		this.baseFood = baseFood;
	}
	
	protected Condiment() { }
	
	public void setBaseFood(Food baseFood) {
		this.baseFood = baseFood;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + baseFood.toString();
	}
	
}
