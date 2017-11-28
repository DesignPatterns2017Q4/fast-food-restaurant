package com.epam.training.designpatterns.fastfoodrestaurant;

import java.util.List;

public class Order {

	Client client;
	Product product;
	List<Extra> extras;
	
	public Order(Client client, Product product, List<Extra> extras) {
		this.client = client;
		this.product = product;
		this.extras = extras;
	}

	public Client getClient() {
		return client;
	}

	public Product getProduct() {
		return product;
	}

	public List<Extra> getExtras() {
		return extras;
	}
	
}
