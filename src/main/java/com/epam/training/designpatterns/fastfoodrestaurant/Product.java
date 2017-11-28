package com.epam.training.designpatterns.fastfoodrestaurant;

public abstract class Product implements Consumable {

	public abstract String getName();
	public abstract int getEffect();
	public abstract void consumedBy(Client client);
	public abstract void setEffect(int effect);

}