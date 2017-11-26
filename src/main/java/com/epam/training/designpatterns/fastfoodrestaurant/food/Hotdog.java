package com.epam.training.designpatterns.fastfoodrestaurant.food;

public class Hotdog implements Food {

	@Override
	public int applyEffect(int happiness) {
		return happiness + 2;
	}
	
	@Override
	public String toString() {
		return "Hotdog";
	}

}
