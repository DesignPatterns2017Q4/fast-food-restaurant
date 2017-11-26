package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.ReadyMeal;

public class DeliveryQueue extends Observable {
	
	private Queue<ReadyMeal> meals = new ConcurrentLinkedQueue<>();

	public void addFinishedMeal(ReadyMeal meal) {
		meals.add(meal);
		setChanged();
		notifyObservers();
	}
	
	public ReadyMeal getNextMeal() {
		return meals.remove();
	}
	
}
