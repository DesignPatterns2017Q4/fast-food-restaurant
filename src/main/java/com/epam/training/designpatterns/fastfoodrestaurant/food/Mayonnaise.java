package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Mayonnaise extends Condiment implements Food {

	public Mayonnaise(Food food) {
		super(food);
	}
	
	public Mayonnaise() {
		super();
	}
	
	@Override
	public int applyEffect(int happiness) {
		if (baseFood != null) {
			return (int) (baseFood.applyEffect(happiness) * 0.9);
		}
		else {
			throw new RuntimeException("Cannot measure effect of a condiment on its own!");
		}
	}
	
}
