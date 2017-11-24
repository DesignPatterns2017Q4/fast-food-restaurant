package com.epam.training.designpatterns.fastfoodrestaurant;

public abstract class Product {

	public int effect;
	
	public abstract void changeClient(Client client);

	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}

}