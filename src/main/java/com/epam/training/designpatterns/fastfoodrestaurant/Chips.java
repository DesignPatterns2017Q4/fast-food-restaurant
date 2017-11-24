package com.epam.training.designpatterns.fastfoodrestaurant;

public class Chips extends Product implements Consumable {

	private int effect = 2; 

	@Override
	public void changeClient(Client client) {
		int clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness * (1 + effect / 100));
	}

	public void consume() {
		
	}

}
