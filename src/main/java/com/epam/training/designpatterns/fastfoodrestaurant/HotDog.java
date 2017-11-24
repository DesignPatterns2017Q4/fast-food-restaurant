package com.epam.training.designpatterns.fastfoodrestaurant;

public class HotDog extends Product implements Consumable {
	
	private int effect = 2; 

	@Override
	public void changeClient(Client client) {
		int clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness + effect);
	}

	public void consume() {
		
	}
	
	

}
