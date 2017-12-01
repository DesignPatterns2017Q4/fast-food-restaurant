package com.epam.training.designpatterns.fastfoodrestaurant;

public class HotDog extends Product implements Consumable {
	
	private double effect = 2.0;
	private final String NAME = "hotdog";

	@Override
	public void consumedBy(Client client) {
		double clientHappiness = client.getHappiness();
		client.setHappiness(clientHappiness + effect);
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public double getEffect() {
		return effect;
	}

	@Override
	public void setEffect(double effect) {
		this.effect = effect;
	}

}
