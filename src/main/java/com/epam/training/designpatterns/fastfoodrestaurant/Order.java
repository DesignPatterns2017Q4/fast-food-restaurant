package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.List;
import java.util.Map;

public class Order {

	Client client;
	Map<Product, List<Extra>> orderedItems;
	
	public Order(Client client, Map<Product, List<Extra>> orderedItems) {
		this.client = client;
		this.orderedItems = orderedItems;
	}
}
