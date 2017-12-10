package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mayonnaise extends Condiment implements Food {

	public Mayonnaise(Food food) {
		super(food);
	}
	
	@Override
	public int applyEffect(int happiness) {
		return (int) (baseFood.applyEffect(happiness) * 0.9);
	}
	
}
