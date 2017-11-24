package com.epam.training.designpatterns.fastfoodrestaurant;

public abstract class Product implements Consumable {

	public int effect;

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	public abstract void consumedBy(Client client);

}