package com.epam.training.designpatterns.fastfoodrestaurant.food;


public class Ketchup extends Condiment implements Food {
	
	public Ketchup(Food food) {
		super(food);	
	}
	
	public Ketchup() {
		super();	
	}
	
	@Override
	public int applyEffect(int happiness) {
		if (baseFood != null) {
			return baseFood.applyEffect(baseFood.applyEffect(happiness));
		}
		else {
			throw new RuntimeException("Cannot measure effect of a condiment on its own!");
		}
	}

}
