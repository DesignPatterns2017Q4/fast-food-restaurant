package com.epam.training.designpatterns.fastfoodrestaurant.food;

public abstract class Condiment {
	
	protected Food baseFood;

	public Condiment(Food baseFood) {
		this.baseFood = baseFood;
	}
	
	public Condiment() { }
	
	public void setBaseFood(Food baseFood) {
		this.baseFood = baseFood;
	}
}
