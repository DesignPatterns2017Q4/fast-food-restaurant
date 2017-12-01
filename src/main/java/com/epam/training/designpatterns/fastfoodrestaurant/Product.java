package com.epam.training.designpatterns.fastfoodrestaurant;

public abstract class Product implements Consumable {

	public abstract String getName();
	public abstract double getEffect();
	public abstract void consumedBy(Client client);
	public abstract void setEffect(double d);

}