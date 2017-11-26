package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mustard extends Condiment implements Food {
	
	public Mustard(Food food) {
		super(food);
	}
	
	public Mustard() {
		super();
	}
	
	@Override
	public int applyEffect(int happiness) {
		if (baseFood != null) {
			return happiness + 1;
		}
		else {
			throw new RuntimeException("Cannot measure effect of a condiment on its own!");
		}
	}
}
