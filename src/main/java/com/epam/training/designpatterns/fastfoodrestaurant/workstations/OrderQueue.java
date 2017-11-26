package com.epam.training.designpatterns.fastfoodrestaurant.workstations;

import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.epam.training.designpatterns.fastfoodrestaurant.entities.Order;


public class OrderQueue extends Observable {
	
	private Queue<Order> orders = new ConcurrentLinkedQueue<>();

	public void addOrder(Order order) {
		orders.add(order);
		setChanged();
		notifyObservers();
	}
	
	public Order getNextOrder() {
		return orders.remove();
	}
	
	public boolean isEmpty() {
		return orders.isEmpty();
	}
	
}
