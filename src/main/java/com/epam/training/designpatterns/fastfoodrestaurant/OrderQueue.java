package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.LinkedList;
import java.util.Queue;

public class OrderQueue{
	private Queue<Order> orders = new LinkedList<Order>();
	
	public boolean addOrder(Order order) {
		return orders.add(order);
	}
	
	public Order getOrder() {
		return orders.poll();
	}
}
