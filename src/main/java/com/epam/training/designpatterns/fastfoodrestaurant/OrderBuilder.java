package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.List;

public class OrderBuilder {

	private Client client;
	private Product product;
	private List<Extra> extras;
	
	public OrderBuilder(Client client) {
		this.client = client;
	}

	public void addProduct(Product product) {
		this.product = product;
	}
	
	public void addExtra(Extra extra) {
		extras.add(extra);
	}
	
	public Order buildOrder() {
		return new Order(client, product, extras);
	}

}
