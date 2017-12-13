package com.epam.training.designpatterns.fastfoodrestaurant.food;


public class Ketchup extends Condiment implements Food {
	
	public Ketchup(Food food) {
		super(food);	
	}
	
	@Override
	public int applyEffect(int happiness) {
		return baseFood.applyEffect(baseFood.applyEffect(happiness));
	}

}
