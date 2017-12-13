package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mustard extends Condiment implements Food {
	
	public Mustard(Food food) {
		super(food);
	}
	
	@Override
	public int applyEffect(int happiness) {
		return happiness + 1;
	}
}
