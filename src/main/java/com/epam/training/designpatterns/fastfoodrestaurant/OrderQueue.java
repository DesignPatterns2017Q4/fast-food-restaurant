package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;

public class OrderQueue implements Fifo<Order> {

	LinkedList<Order> orders;
	
	public OrderQueue() {
		this.orders = new LinkedList<Order>();
	}

	public Order pop() {
		return orders.removeFirst();
	}

	public void put(Order order) {
		orders.addLast(order);
	}
	
	public int size() {
		return orders.size();
	}

}
