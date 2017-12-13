package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Chips implements Food {

	@Override
	public int applyEffect(int happiness) {
		return (int) (happiness * 1.05);
	}
	
	@Override
	public String toString() {
		return "Chips";
	}

}
