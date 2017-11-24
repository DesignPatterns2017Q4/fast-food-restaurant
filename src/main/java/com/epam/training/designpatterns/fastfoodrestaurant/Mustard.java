package com.epam.training.designpatterns.fastfoodrestaurant;

public class Mustard extends Extra implements Consumable, ProductModifier {

	public void modifyEffectOfProduct(Product product) {
		product.setEffect(0);
	}

	public void consumedBy(Client client) {
		int clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness + 1);
	}

}
