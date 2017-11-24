package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderBuilder {

	private Client client;
	private Product product;
	private List<Extra> extras;
	private Order order;
	private Map<Product, List<Extra>> orderedItems;
	
	public OrderBuilder() {
		this.orderedItems = new HashMap<Product, List<Extra>>();
	}

	public void addProduct(Product product) {
		this.extras = new ArrayList<Extra>();
		this.product = product;
	}
	
	public void addExtra(Extra extra) {
		extras.add(extra);
	}
	
	public Order buildOrder() {
		orderedItems.put(product, extras);
		return new Order(client, orderedItems);
	}

}
